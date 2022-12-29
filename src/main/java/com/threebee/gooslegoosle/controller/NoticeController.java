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
import com.threebee.gooslegoosle.service.NoticeService;


@Controller
public class NoticeController {

	
	@Autowired
	NoticeService noticeservice;
	
	@GetMapping("/notice")
	public String fetchNoticeList(Model model,
			@PageableDefault(size = 6, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		Page<NoticeEntity> notice = noticeservice.getNoticeList(pageable);
	
		model.addAttribute("notice", notice);
		return "notice/notice_list";
	}	
	
	@GetMapping("/notice/{id}")
	public String fetchNoticeDetail(@PathVariable int id, Model model) {
		
		model.addAttribute("notice", noticeservice.getNoticeDetail(id));
		return "/notice/notice_detail";
	}

	
	@GetMapping("/notice/board")
	public String fetchNotice() {
		
		return "/notice/notice_save";
	}

	@GetMapping("/notice/update/{id}")
	public String fetchNoticeUpdate(@PathVariable int id, Model model) {
		NoticeEntity notice = noticeservice.getNoticeDetail(id);
		model.addAttribute("notice", notice);
		return "/notice/notice_update";
	}	
	
	@GetMapping("/notice/delete/{id}")
	public String fetchNoticedelete(@PathVariable int id, Model model,
			@PageableDefault(size = 6, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		
		noticeservice.deleteNoticeById(id);
		Page<NoticeEntity> notice = noticeservice.getNoticeList(pageable);
		
		model.addAttribute("notice", notice);
		return "notice/notice_list";
	}
	
}
