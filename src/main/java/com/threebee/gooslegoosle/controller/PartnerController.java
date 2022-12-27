package com.threebee.gooslegoosle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PartnerController {

	@GetMapping("/auth/partner/main_page")
	public String partnerMain() {
		return "partner/main_page";
	}
	
	
	@GetMapping("/auth/partner/join_form")
	public String partnerJoinForm() {
		return "partner/join_form";
	}

}
 