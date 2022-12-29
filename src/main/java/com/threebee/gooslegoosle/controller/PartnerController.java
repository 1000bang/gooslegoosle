package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.service.PartnerService;

@Controller
public class PartnerController {

	@Autowired
	PartnerService partnerService;
	

	@GetMapping("/auth/partner/main_partner")
	public String partnerMain() {
		return "partner/main_partner";
	}
	
	@GetMapping("/partner/application_partner")
	public String partnerJoinForm() {
		return "partner/application_partner";
	}

	@GetMapping("/partner/apply_store")
	public String applyStore() {
		return "partner/apply_store";
	}
	
	@GetMapping("/auth/partner/apply_menu/{id}")
	public String applyMenu(@PathVariable int id, Model model) {
		
		PartnerEntity store = partnerService.findStoreByUserId(id);
		model.addAttribute("store", store);
		
		return "partner/apply_menu";
	}
	
}
 