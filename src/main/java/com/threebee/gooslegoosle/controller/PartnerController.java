package com.threebee.gooslegoosle.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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

import com.threebee.gooslegoosle.dto.PartnerAndStoreDTO;
import com.threebee.gooslegoosle.dto.PartnerFileDTO;
import com.threebee.gooslegoosle.dto.ResApproveDto;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.dto.StoreFileDTO;
import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.ReservationEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
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
	private UserService userService;

	@GetMapping("/auth/partner/main_partner")
	public String fetchPartner() {
		return "partner/main_partner";
	}

	@GetMapping("/partner/application_partner")
	public String fetchApplicationPartnerForm() {
		return "partner/application_partner";
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
	public String fetchRes(@PathVariable int id, Model model) {
		StoreEntity store = storeService.findByUserId(id);
		List<ReservationEntity> res = reservationService.findByStoreId(store.getId());
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
		for (int i = 0; i < resId.getId().size(); i++) {
			reservationService.setApprove(resId.getId().get(i));
		}
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	@PostMapping("reservation/deny")
	@ResponseBody
	public ResponseDto<Integer> fetchDenyRes(@RequestBody ResApproveDto resId) {
	
		for (int i = 0; i < resId.getId().size(); i++) {
			reservationService.setDeny(resId.getId().get(i));
		}
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	

}
