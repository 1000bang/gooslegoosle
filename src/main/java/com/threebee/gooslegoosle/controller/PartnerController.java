package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threebee.gooslegoosle.dto.PartnerFileDTO;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.UserService;

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
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/partner/{id}")
	public String savePartner( PartnerFileDTO partner,
			@PathVariable int id){
		
			System.out.println("111111111");
		    System.out.println(partner);
		    UserEntity user = userService.findId(id);
		
		partnerService.savePartner(partner, user);
		 
		return "partner/main_partner";
		
	}

}
