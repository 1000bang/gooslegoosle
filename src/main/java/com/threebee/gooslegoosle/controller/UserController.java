package com.threebee.gooslegoosle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.dto.kakao.pay.PaymentResDto;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.ReservationEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.model.GoogleLogin;
import com.threebee.gooslegoosle.model.KakaoLogin;
import com.threebee.gooslegoosle.model.NaverLogin;
import com.threebee.gooslegoosle.model.SocialLogin;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.ReservationService;
import com.threebee.gooslegoosle.service.StoreService;
import com.threebee.gooslegoosle.service.UserService;

@Controller
public class UserController {

	@Autowired
	PartnerService partnerService;
	
	@Autowired
	StoreService storeService;
	
	@GetMapping("test")
	public String test() {
		return "user/test";
	}
	
	@GetMapping({ "", "/", "index", "search"})
	public String fetchIndex(@RequestParam(required = false) String searchWord,Model model, @PageableDefault(size = 20, sort = "id", direction = Direction.DESC) Pageable pageable) {
		String searchWords = searchWord == null ? "": searchWord;
		
		List<StoreEntity> store = storeService.findAll(searchWords, pageable);
		Page<StoreEntity> koreanStore = storeService.findKorean(searchWords, pageable);
		Page<StoreEntity> japanessStore = storeService.findJapaness(searchWords, pageable);
		Page<StoreEntity> chineseStore = storeService.findChinese(searchWords, pageable);
		Page<StoreEntity> westernStore = storeService.findWestern(searchWords, pageable);
		
		model.addAttribute("store",store);
		model.addAttribute("koreanStore",koreanStore);
		model.addAttribute("japanessStore",japanessStore);
		model.addAttribute("chineseStore",chineseStore);
		model.addAttribute("westernStore",westernStore);
		return "index";
	}

	@GetMapping("/api/user/{id}")
	public String fetchAdmin(@PathVariable int id) {
		UserEntity user = userService.setAdmin(id);
		return "redirect:/";
	}
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/myReservation")
	public String fetchMyRes(@AuthenticationPrincipal PrincipalDetail detail, Model model) {
		List<ReservationEntity> res = reservationService.findByUserid(detail.getUser().getId());
		model.addAttribute("reservation", res);
		return "user/reservation";
	}
	
	@GetMapping("/pay/return/{id}")
	public String fetchReturn(@PathVariable int id, @AuthenticationPrincipal PrincipalDetail detail, Model model) {
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		ReservationEntity res = reservationService.findById(id);
		headers.add("Authorization", "KakaoAK 11f4787a3e20f1290090dbe6f4969397");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", res.getTid());
		params.add("cancel_amount", "20000"); // <-- 주문 번호가 없음.ㅠ
		params.add("cancel_tax_free_amount", "0");
		
		HttpEntity<MultiValueMap<String, String>> reqCancle = new HttpEntity<>(params,headers);
		
		// 헤더를 변조해서 넣는 코드
		ResponseEntity<String> response = rt.exchange("https://kapi.kakao.com/v1/payment/cancel", HttpMethod.POST,
				reqCancle, String.class);
		reservationService.setCancle(res.getId());
		List<ReservationEntity> reservation = reservationService.findByUserid(detail.getUser().getId());
		model.addAttribute("reservation", reservation);
		return "user/reservation";
	}
	
	@GetMapping("/auth/login_form")
	public String fetchLogin(@RequestParam(value = "error", required = false) String error,
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
		//TODO
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
			userService.saveUser(user);

		}
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}