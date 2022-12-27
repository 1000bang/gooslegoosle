package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.model.GoogleLogin;
import com.threebee.gooslegoosle.model.KakaoLogin;
import com.threebee.gooslegoosle.model.NaverLogin;
import com.threebee.gooslegoosle.model.SocialLogin;
import com.threebee.gooslegoosle.service.UserService;

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
	
	
	
	//소셜 로그인 
	@GetMapping("/auth/callback")
	public String fetchLoginBySocial(@RequestParam String code, @RequestParam String state, @RequestParam(required = false) String scope) {
		
		KakaoLogin kakao = new KakaoLogin();
		GoogleLogin google = new GoogleLogin(scope);
		NaverLogin naver = new NaverLogin(state);
		SocialLogin socialLogin = new SocialLogin(kakao);
		UserEntity userData = null;
		
		
		if(state.equals("kakao")) {
			userData =  socialLogin.login(code);
		}else if (state.equals("google")) {
			socialLogin.setISocialLogin(google);
			userData = socialLogin.login(code);
		}else {
			socialLogin.setISocialLogin(naver);
			userData = socialLogin.login(code);
		}
		
		findAndLoginUser(userData);
		
		
		return "redirect:/";
	}
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
	public void findAndLoginUser(UserEntity user) {

		UserEntity originUser = userService.searchUserName(user.getUsername());

		if (originUser.getUsername() == null) {
			System.out.println("신규회원이기 때문에 회원가입 진행 ");
			userService.saveUser(user);

		}

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
}