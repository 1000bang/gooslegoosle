package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.threebee.gooslegoosle.entity.NoticeEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.NoticeService;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.UserService;

@Controller
public class AdminController {

	@Autowired
	PartnerService partnerService;

	@Autowired
	UserService userService;

	@GetMapping("/admin/manage")
	public String fetchAwaitingList(Model model,
			@PageableDefault(size = 10, sort = "id", direction = Direction.DESC) Pageable pageable) {

		Page<StoreEntity> store = partnerService.getApplyList(pageable);

		model.addAttribute("store", store);
		return "admin/manage";
	}
	
	@Autowired
	NoticeService noticeservice;
	
	@GetMapping("/admin/notice")
	public String fetchNoticeList(Model model,
			@PageableDefault(size = 6, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		Page<NoticeEntity> notice = noticeservice.getNoticeList(pageable);
		
		
		
		
		model.addAttribute("notice", notice);
		return "admin/notice";
	}	
	
	@GetMapping("/admin/notice/{id}")
	public String fetchNoticeDetail(@PathVariable int id, Model model) {
		
		model.addAttribute("notice", noticeservice.getNoticeDetail(id));
		return "/admin/notice_detail";
	}
	
	@GetMapping("/admin/notice/board")
	public String fetchBoard() {
		

		return "admin/save_form";
	}


	@GetMapping("/admin/manage/approve/{id}")
	public String fetchApprove(@PathVariable int id) {
		System.out.println("id >>>>>>" + id);
		StoreEntity store = partnerService.findStore(id);
		System.out.println(store);
		UserEntity user = store.getUser();
		userService.setHost(user.getId());
		partnerService.setApprove(store, user);

		return "/admin/manage";
	}
	
	@GetMapping("/admin/manage/deny/{id}")
	public String fetchDeny(@PathVariable int id) {
		System.out.println("id >>>>>>" + id);
		partnerService.setDeny(id);
		return "/admin/manage";
	}

}
