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
	public String fetchPartner() {
		return "partner/main_partner";
	}
	
	@GetMapping("/partner/application_partner")
	public String fetchApplicationPartnerForm() {
		return "partner/application_partner";
	}

	@GetMapping("/partner/add_store")
	public String fetchAddStore() {
		return "partner/add_store";
	}
	
	@GetMapping("/partner/add_partner/{id}")
	public String fetchAddPartner(@PathVariable int id, Model model) {
		
		PartnerEntity partner = partnerService.findStoreByUserId(id);
		model.addAttribute("partner", partner);
		
		return "partner/add_partner";
	}
	
	@GetMapping("/partner/add_menu/{id}")
	public String fetchAddMenu(@PathVariable int id, Model model) {
		PartnerEntity partner = partnerService.findStoreById(id);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + partner);
		return "partner/add_menu";	
				
	}
	
	
}
 