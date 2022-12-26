package com.threebee.gooslegoosle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

	
	@GetMapping({ "", "/", "index" })
	public String fetchIndex() {
		 return "index";
	}
	
	
	@GetMapping("/auth/login")
	public String fetchLogin() {
		 return "user/login_form";
	}
	
	
}
