package com.threebee.gooslegoosle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	
	@GetMapping({ "", "/", "index" })
	public String fetchIndex() {
		 return "index";
	}
	
	
	@GetMapping("/auth/login_form")
	public String fetchLogin() {
		 return "user/login_form";
	}
	
	
	@GetMapping("/auth/join_form")
	public String fetchJoin() {
		 return "user/join_form";
	}
}