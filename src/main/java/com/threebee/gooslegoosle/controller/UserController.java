package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/api/user/{id}")
	public String fetchAdmin(@PathVariable int id) {
		UserEntity user = userService.findbyid(id);
		return "redirect:/";
	}
	
	@GetMapping("/auth/login_form")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception", required = false) String exception, Model model) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "user/login_form";
	}

	@GetMapping("/auth/join_form")
	public String fetchJoin() {
		return "user/join_form";
	}

	@GetMapping("/user/update")
	public String fetchUpdate() {
		return "user/update_form";
	}

	// 소셜 로그인
	@GetMapping("/auth/callback")
	public String fetchLoginBySocial(@RequestParam String code, @RequestParam String state,
			@RequestParam(required = false) String scope) {

		KakaoLogin kakao = new KakaoLogin();
		GoogleLogin google = new GoogleLogin(scope);
		NaverLogin naver = new NaverLogin(state);
		SocialLogin socialLogin = new SocialLogin(kakao);
		UserEntity userData;

		if (state.equals("kakao")) {
			userData = socialLogin.login(code);
		} else if (state.equals("google")) {
			socialLogin.setISocialLogin(google);
			userData = socialLogin.login(code);
		} else {
			socialLogin.setISocialLogin(naver);
			userData = socialLogin.login(code);
		}

		findAndLoginUser(userData);

		return "redirect:/";
	}

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private BCryptPasswordEncoder bcencoder;

	@Autowired
	private UserService userService;


	
	
	public void findAndLoginUser(UserEntity user) {

		UserEntity originUser = userService.findUserName(user.getUsername());

		if (originUser.getUsername() == null) {
			System.out.println("신규회원이기 때문에 회원가입 진행 ");
			userService.saveUser(user);

		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		System.out.println(">>>>>>>>>>>>>>>>>"+authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}