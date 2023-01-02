package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/partner/add_store/{id}")
	public String fetchAddStore(@PathVariable int id, Model model) {
		
		//TODO partner null 수정
		PartnerEntity store = partnerService.findStoreByUserId(id);
		System.out.println("store ===========>>>>" + store.toString());
		model.addAttribute("store", store);
		System.out.println("store=====" + store.getId());
		return "partner/add_store";
	}

	@GetMapping("/partner/add_partner/{id}")
	@ResponseBody
	public String fetchAddPartner(@PathVariable int id, Model model) {

		PartnerEntity store = partnerService.findStoreByUserId(id);
		model.addAttribute("store", store);

		return "10";

	}

	@GetMapping("/partner/add_menu/{id}")
	public String fetchAddMenu(@PathVariable int id, Model model) {
		partnerService.setUpload(id);
		PartnerEntity partner = partnerService.findStoreById(id);
		model.addAttribute("partner", partner);
		return "partner/add_menu";

	}

}
