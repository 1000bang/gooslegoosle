package com.threebee.gooslegoosle.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threebee.gooslegoosle.dto.ChartDto;
import com.threebee.gooslegoosle.dto.ChartMonthDTO;
import com.threebee.gooslegoosle.dto.ChartSixMonthDTO;
import com.threebee.gooslegoosle.dto.PartnerAndStoreDTO;
import com.threebee.gooslegoosle.dto.PartnerFileDTO;
import com.threebee.gooslegoosle.dto.ResApproveDto;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.dto.StoreFileDTO;
import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.MessageEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.ReservationEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.MessageService;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.ReservationService;
import com.threebee.gooslegoosle.service.StoreService;
import com.threebee.gooslegoosle.service.UserService;

@Controller
public class PartnerController {

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/auth/partner/main_partner")
	public String fetchPartner() {
		return "partner/main_partner";
	}

	@GetMapping("/partner/application_partner")
	public String fetchApplicationPartnerForm() {
		return "partner/application_partner";
	}

	@GetMapping("/partner/chart/{id}")
	public String fetchChart(Model model, @PathVariable int id) {
		StoreEntity store = storeService.findByUserId(id);

		// 일별 통계
		List<ChartDto> res = reservationService.findByStoreIdWeek(store.getId());
		List<List<?>> day = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			List<String> data2 = new ArrayList<>();
			data2.add(res.get(i).getDate());
			data2.add(res.get(i).getCount());
			day.add(data2);
		}

		// 주별 통계
		List<ChartMonthDTO> week = reservationService.findByStoreIdMonth(store.getId());

		List<ChartSixMonthDTO> month = reservationService.findByStoreIdHalfYear(store.getId());
		System.out.println(">>>>>>>" + day);
		System.out.println(">>>>>>>" + week);
		model.addAttribute("day", day);
		model.addAttribute("week", week);
		model.addAttribute("month", month);
		return "store/chart";
	}

	@GetMapping("/partner/updateStore/{id}")
	public String fetchUpdate(Model model, @PathVariable int id) {
		PartnerEntity partner = partnerService.findPartnerByUserId(id);
		StoreEntity store = storeService.findByUserId(id);
		model.addAttribute("store", store);
		model.addAttribute("partner", partner);
		return "store/store_update";
	}

	@Autowired
	ReservationService reservationService;

	@GetMapping("/partner/reservation/{id}")
	public String fetchRes(@PathVariable int id, Model model,
			@PageableDefault(size = 8, sort = "id", direction = Direction.DESC) Pageable pageable) {
		StoreEntity store = storeService.findByUserId(id);
		Page<ReservationEntity> res = reservationService.findByStoreId(store.getId(), pageable);
		int nowPage = res.getPageable().getPageNumber() + 1;
		int startPageNumber = Math.max(nowPage - 2, 1);
		int endPageNumber = Math.min(nowPage + 2, res.getTotalPages());
		int end = res.getTotalPages() - 1;

		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			pageNumbers.add(i);
		}
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", 0);
		model.addAttribute("endPage", end);
		model.addAttribute("reservation", res);
		return "store/store_res";
	}

	@PostMapping("/partner/{id}")
	public String fetchSavePartner(PartnerFileDTO partner, @PathVariable int id) {
		System.out.println(partner);
		UserEntity user = userService.findId(id);

		partnerService.savePartner(partner, user);

		return "partner/main_partner";
	}

	@GetMapping("/partner/addstore/{id}")
	public String fetchAddStore(@PathVariable int id, Model model) {

		// TODO partner null 수정
		PartnerEntity partner = partnerService.findPartnerByUserId(id);
		model.addAttribute("partner", partner);
		return "partner/add_store";
	}

	@PostMapping("/partner/add_store/{id}")
	public String fetchSaveStore(StoreFileDTO store, @PathVariable int id, Model model) {

		PartnerEntity partner = partnerService.findPartnerById(id);
		if (storeService.findByUserId(partner.getUser().getId()) != null) {
			System.out.println(">>>>>>>>>here");
			return "partner/fail_store";
		}
		;
		StoreEntity stores = storeService.saveStore(store, partner);
		List<MenuEntity> menus = partnerService.findMenuByStoreId(stores.getId());
		model.addAttribute("menus", menus);
		model.addAttribute("store", stores);
		return "partner/add_menu";
	}

	@PostMapping("/partner/add_menu/{id}")
	@ResponseBody
	public ResponseDto<MenuEntity> fetchSaveMenu(@RequestBody MenuEntity menu, @PathVariable int id) {
		StoreEntity store = storeService.findStoreByStoreId(id);
		MenuEntity menus = partnerService.saveMenu(menu, store);

		return new ResponseDto<MenuEntity>(HttpStatus.OK, menus);
	}

	@PostMapping("/partner/add_menu/{id}/done")
	@ResponseBody
	public ResponseDto<Integer> fetchSaveMenuDone(@RequestBody MenuEntity menu, @PathVariable int id) {
		StoreEntity store = storeService.findStoreByStoreId(id);
		partnerService.setUpload(id);
		if (menu.getMenuName() == null || menu.getMenuName().equals("")) {
		} else {
			partnerService.saveMenu(menu, store);
		}
		MessageEntity newMsg = MessageEntity.builder()
				.comment(store.getUser().getUserNickname() + "님 구슬구슬 가게등록을 성공하셨습니다. \n" + "\t\t- 구슬구슬 팀").build();
		messageService.sendMessageByUserId(store.getUser().getId(), newMsg);

		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	@PostMapping("/store/update/{id}")
	@ResponseBody
	public ResponseDto<Integer> fetchUpdateSnP(@RequestBody PartnerAndStoreDTO dto, @PathVariable int id) {
		System.out.println(dto);
		partnerService.updateAll(id, dto);

		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	// 가게수정시 사할 예정
	@DeleteMapping("/menu/delete/{id}")
	@ResponseBody
	public ResponseDto<Integer> fetchDeleteMenu(@PathVariable int id) {
		partnerService.deleteMenu(id);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	@PutMapping("/menu/update/{id}")
	@ResponseBody
	public ResponseDto<Integer> fetchUpdateMenu(@PathVariable int id, @RequestBody MenuEntity menu) {
		partnerService.updateMenu(id, menu);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	@PostMapping("reservation/approve")
	@ResponseBody
	public ResponseDto<Integer> fetchApproveRes(@RequestBody ResApproveDto resId) {
		System.out.println(resId);
		ReservationEntity user = null;
		for (int i = 0; i < resId.getId().size(); i++) {
			user = reservationService.setApprove(resId.getId().get(i));
			MessageEntity newMsg = MessageEntity.builder()
					.comment(user.getUser().getUserNickname() + "님 "+ user.getStore().getPartner().getStoreName() +"예약 승인되었습니다. \n \t\t- 구슬구슬 팀").build();
			messageService.sendMessageByUserId(user.getUser().getId(), newMsg);
			
		}

		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	@PostMapping("reservation/deny")
	@ResponseBody
	public ResponseDto<Integer> fetchDenyRes(@RequestBody ResApproveDto resId) {
		ReservationEntity user = null;
		for (int i = 0; i < resId.getId().size(); i++) {
			user = reservationService.setDeny(resId.getId().get(i));
			MessageEntity newMsg = MessageEntity.builder()
					.comment(user.getUser().getUserNickname() + "님 "+ user.getStore().getPartner().getStoreName() +"예약 거절되었습니다. \n \t\t- 구슬구슬 팀").build();
			messageService.sendMessageByUserId(user.getUser().getId(), newMsg);
			
		}
		

		
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

}
