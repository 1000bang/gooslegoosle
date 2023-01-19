package com.threebee.gooslegoosle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threebee.gooslegoosle.dto.ChartDto;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.MessageEntity;
import com.threebee.gooslegoosle.entity.NoticeEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.MessageService;
import com.threebee.gooslegoosle.service.NoticeService;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.ReviewService;
import com.threebee.gooslegoosle.service.UserService;

@Controller
public class AdminController {

	@Autowired
	PartnerService partnerService;

	@Autowired
	UserService userService;

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	MessageService messageService;
	
	@GetMapping({"/admin/manage", "/admin/manage/search"})
	public String fetchAwaitingList(Model model, @RequestParam(required = false) String q,
			@PageableDefault(size = 4, sort = "id", direction = Direction.DESC) Pageable pageable) {

		String searchPartner = q == null? "": q;
		
		Page<PartnerEntity> partner = partnerService.getApplyList(searchPartner ,pageable);
		int nowPage = partner.getPageable().getPageNumber() + 1;
		int startPageNumber = Math.max(nowPage - 2, 1);
		int endPageNumber = Math.min(nowPage + 2, partner.getTotalPages());
		int end = partner.getTotalPages() - 1;

		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for (int i = startPageNumber; i < endPageNumber; i++) {
			pageNumbers.add(i);
		}
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", 0);
		model.addAttribute("endPage", end);
		model.addAttribute("store", partner);
		return "admin/manage";
	}
	
	@GetMapping("/admin/message/{id}")
	public String fetchMessage(@PathVariable int id, Model model) {
		System.out.println("id>>>>>>>." +id);
		UserEntity user = userService.findId(id);
		model.addAttribute("user",user);
		return "admin/message";
	}
	
	@PostMapping("/admin/message/send/{id}")
	@ResponseBody
	public ResponseDto<Integer> fetchSendMessage(@PathVariable int id, @RequestBody MessageEntity mes) {
		messageService.sendMessageByUserId(id, mes);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	@GetMapping("/admin/manage/approve/{id}")
	public String fetchApprove(@PathVariable int id) {
		PartnerEntity store = partnerService.findPartnerById(id);
		System.out.println(store);
		UserEntity user = store.getUser();
		UserEntity users = userService.setHost(user.getId());
		partnerService.setApprove(store, users);
		MessageEntity newMsg = MessageEntity.builder()
				.comment(user.getUserNickname()+"님 구슬구슬 파트너로 승인되셨습니다. \n"
						+ "\t\t- 구슬구슬 팀")
				.build();
		
		System.out.println("11111");
		messageService.sendMessageByUserId(user.getId(), newMsg);
		return "redirect:/admin/manage";
	}
	
	@GetMapping("/admin/manage/deny/{id}")
	public String fetchDeny(@PathVariable int id) {
		partnerService.setDeny(id);
		return "redirect:/admin/manage";
	}
	
	@GetMapping({"/admin/user", "/admin/user/search"})
	public String fetchUser(Model model,@RequestParam(required = false) String q, @PageableDefault(size = 10, sort = "id", direction = Direction.DESC) Pageable pageable) {

		String searchUser = q == null? "": q;
		
		Page<UserEntity> user = userService.findAll(searchUser, pageable);
		int nowPage = user.getPageable().getPageNumber() + 1;
		int startPageNumber = Math.max(nowPage - 2, 1);
		int endPageNumber = Math.min(nowPage + 2, user.getTotalPages());
		int end = user.getTotalPages() - 1;
	
		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			pageNumbers.add(i);
		}
		
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", 0);
		model.addAttribute("endPage", end);
		model.addAttribute("user", user);
		model.addAttribute("q", searchUser);
		return "admin/user_list";
	}
	
	@GetMapping("/admin/warning/{id}")
	public String fetchWarningUser(@PathVariable int id, Model model) {
		UserEntity user = userService.setWarningUser(id);
		MessageEntity newMsg = MessageEntity.builder().user(user).comment("안녕하세요 " + user.getUserNickname()
		+ "님 \n 사용자의 신고로 인해 경고조치, 현재 총" + user.getWarning() + "회 적용되었습니다. \n \t\t - 구슬구슬 팀").build();
		messageService.sendMessageByUserId(user.getId(), newMsg);
		return "redirect:/admin/user";
	}

	@GetMapping("/admin/stop/{id}")
	public String fetchStopUser(@PathVariable int id, Model model) {
		userService.stopUser(id);

		return "redirect:/admin/user";
	}
	
	@GetMapping("/admin/unstop/{id}")
	public String fetchUnStopUser(@PathVariable int id, Model model) {
	 UserEntity user = userService.unStopUser(id);
	 MessageEntity newMsg = MessageEntity.builder()
				.comment(user.getUserNickname()+"님 구슬구슬 정지가 해제되셨습니다. \n"
						+ "\t\t- 구슬구슬 팀")
				.build();
		messageService.sendMessageByUserId(user.getId(), newMsg);
		return "redirect:/admin/user";
	}
	
	@GetMapping("/admin/statics")
	public String fetchStatics(Model model) {
		List<ChartDto>  partner = partnerService.lastTwoWeeksPartner();
		List<ChartDto> review = reviewService.lastTwoWeeksReview();
		List<ChartDto> user = userService.lastTwoWeeksUser();
		
		List<List<?>> part = new ArrayList<>();
		for (int i = 0; i < partner.size(); i++) {
			List<String> data = new ArrayList<>();
			data.add(partner.get(i).getDate());
			data.add(partner.get(i).getCount());
			part.add(data);
		}
		List<List<?>> rev = new ArrayList<>();
		for (int i = 0; i < review.size(); i++) {
			List<String> data = new ArrayList<>();
			data.add(review.get(i).getDate());
			data.add(review.get(i).getCount());
			rev.add(data);
		}
		List<List<?>> use = new ArrayList<>();
		for (int i = 0; i < user.size(); i++) {
			List<String> data = new ArrayList<>();
			data.add(user.get(i).getDate());
			data.add(user.get(i).getCount());
			use.add(data);
		}
		
		model.addAttribute("user", use);
		model.addAttribute("review", rev);
		model.addAttribute("partner", part);
		
		return "/admin/statics";
	}


}
