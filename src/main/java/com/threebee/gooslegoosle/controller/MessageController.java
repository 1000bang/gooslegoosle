package com.threebee.gooslegoosle.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.threebee.gooslegoosle.entity.MessageEntity;
import com.threebee.gooslegoosle.service.MyMessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MyMessageService myMessageService;

	@GetMapping("/my_message")
	public String fetchMessageList( Model model,
			@PageableDefault(size = 10, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		Page<MessageEntity> myMessage = myMessageService.getMessageList(pageable);
		int nowPage = myMessage.getPageable().getPageNumber() + 1;
		int startPageNumber = Math.max(nowPage - 2, 1);
		int endPageNumber = Math.min(nowPage + 2, myMessage.getTotalPages());
		int end = myMessage.getTotalPages() - 1;

		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			pageNumbers.add(i);
		}
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", 0);
		model.addAttribute("endPage", end);

		model.addAttribute("message", myMessage);
		return "message/my_message";
	}
	
	@GetMapping("/my_message/{id}")
	public String getchMessageDetail(@PathVariable int id, Model model) {
		model.addAttribute("message", myMessageService.getMessageDetail(id));
		
		return "/message/my_message_detail";
	}
}
