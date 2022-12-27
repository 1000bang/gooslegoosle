package com.threebee.gooslegoosle.model;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.threebee.gooslegoosle.dto.OAuthToken;
import com.threebee.gooslegoosle.dto.google.GoogleProfileDto;
import com.threebee.gooslegoosle.entity.UserEntity;



public class GoogleLogin implements ISocialLogin{

	 
	String scope;

	public GoogleLogin( String scope) {
	
	this.scope = scope;
	}
	
	
	@Override
	public UserEntity login(String code) {

		RestTemplate rt = new RestTemplate();
		// 헤더 만들기
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 바디 만들기
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("code", code);
		params.add("client_id", "581731462324-vd9i5jd12s0j4d97jcv6n57l1nf2suik.apps.googleusercontent.com");
		params.add("client_secret", "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");
		params.add("redirect_uri", "http://localhost:9090/auth/callback");
		params.add("grant_type", "authorization_code");

		HttpEntity<MultiValueMap<String, String>> requestGoogleToken = new HttpEntity<>(params, headers);

		// 헤더 변조 해서 실행 시키는 메서드 RestTemplate exchange() 이다.
		ResponseEntity<OAuthToken> response = rt.exchange("https://oauth2.googleapis.com/token", HttpMethod.POST,
				requestGoogleToken, OAuthToken.class);
		System.out.println(code);
		System.out.println(scope);

		///

		String accessToken = response.getBody().accessToken;
		String tokentype = response.getBody().tokenType;
		String idtoken = response.getBody().idToken;
		RestTemplate rt2 = new RestTemplate();
		// header
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", tokentype + accessToken);
		headers2.add("Content-type", "application/x-www-form-urlencoded;");

		HttpEntity<MultiValueMap<String, String>> googleDataRequest = new HttpEntity<>(headers2);
		ResponseEntity<GoogleProfileDto> googleDataResponse = rt2.exchange("https://www.googleapis.com/oauth2/v1/userinfo",
				HttpMethod.GET, googleDataRequest, GoogleProfileDto.class);
		GoogleProfileDto account = googleDataResponse.getBody();
		UserEntity googleUser = UserEntity.builder()
				.username(account.name + account.id)
				.email(account.email)
				.password(account.email)
				.phoneNumber("000-0000-0000")
				.role(UserRole.USER)
				.loginType(LoginType.GOOGLE)
				.build();
		
		
		
		return googleUser;
	}

}
