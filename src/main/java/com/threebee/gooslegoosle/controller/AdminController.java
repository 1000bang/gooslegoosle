package com.threebee.gooslegoosle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	
	
	@GetMapping("/admin/manage")
	public String partnerMain(Model model) {
		
//		model.addAttribute("asd", );
		return "admin/manage";
	}
	
		
}
 