package com.threebee.gooslegoosle.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.threebee.gooslegoosle.dto.OAuthToken;
import com.threebee.gooslegoosle.dto.naver.NaverProfileDto;
import com.threebee.gooslegoosle.entity.UserEntity;


public class NaverLogin implements ISocialLogin{

	private String state;
	public NaverLogin(String state) {
	this.state = state;
	}
	
	@Override
	public UserEntity login(String code) {
		String clientId = "IdFsFqY3HF0S1iEY73kF";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "ApO2UiJob6";// 애플리케이션 클라이언트 시크릿값";
		String code2 = code;
		String state2 = state;
		String redirectURI = null;
		try {
			redirectURI = URLEncoder.encode("http://localhost:9090/auth/naver/callback", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token";

		RestTemplate rt = new RestTemplate();
		// 헤더 만들기
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 바디 만들기
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("redirect_uri", redirectURI);
		params.add("code", code);
		params.add("state", state);

		HttpEntity<MultiValueMap<String, String>> requestNaverToken = new HttpEntity<>(params, headers);

		// 헤더 변조 해서 실행 시키는 메서드 RestTemplate exchange() 이다.
		ResponseEntity<OAuthToken> response = rt.exchange(apiURL, HttpMethod.POST, requestNaverToken, OAuthToken.class);

		OAuthToken authtoken = response.getBody();
		RestTemplate rt2 = new RestTemplate();
		// header
		HttpHeaders headers2 = new HttpHeaders();

		headers2.add("Authorization", "Bearer " + authtoken.accessToken);
		headers2.add("Content-type", "application/x-www-form-urlencoded;");

		// JWT 주의 bearer 다음에 무조건 한칸 띄우기

		HttpEntity<MultiValueMap<String, String>> naverRequest = new HttpEntity<>(headers2);
		// 파싱 받을 dto 만들어야 함
		ResponseEntity<NaverProfileDto> naverDataResponse = rt2.exchange("https://openapi.naver.com/v1/nid/me",
				HttpMethod.POST, naverRequest, NaverProfileDto.class);
		
		NaverProfileDto account = naverDataResponse.getBody();
		UserEntity naverUser = UserEntity.builder()
				.username(account.response.name + account.response.id)
				.email(account.response.email)
				.password(account.response.id)
				.phoneNumber("000-0000-0000")
				.role(UserRole.USER)
				.loginType(LoginType.NAVER)
				.build();
		
		
		return naverUser;

	}

}
