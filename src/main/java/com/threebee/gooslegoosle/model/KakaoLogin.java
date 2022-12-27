package com.threebee.gooslegoosle.model;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.threebee.gooslegoosle.dto.OAuthToken;
import com.threebee.gooslegoosle.dto.kakao.login.KakaoProfileDto;
import com.threebee.gooslegoosle.entity.UserEntity;



public class KakaoLogin  implements ISocialLogin{

	
	@Override
	public UserEntity login(String code) {
		RestTemplate rt = new RestTemplate();
		// 헤더 만들기
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 바디 만들기
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "026e230aaa7d30f98a0e8cad9f217377");
		params.add("redirect_uri", "http://localhost:9090/auth/callback");
		params.add("code", code);

		HttpEntity<MultiValueMap<String, String>> requestKakaoToken = new HttpEntity<>(params, headers);

		// 헤더 변조 해서 실행 시키는 메서드 RestTemplate exchange() 이다.
		ResponseEntity<OAuthToken> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST,
				requestKakaoToken, OAuthToken.class);
 
		//////////////////// 여기까지 토큰 받기 완료 //////////////////////

		// 다시 한번 더 kapi.kakaocom 로 토큰을 가지고 요청하여 사용자 정보를 응답받아야 한다.
		OAuthToken authtoken = response.getBody();
		RestTemplate rt2 = new RestTemplate();
		// header
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + authtoken.accessToken);
		headers2.add("Content-type", "application/x-www-form-urlencoded;");
		// JWT 주의 bearer 다음에 무조건 한칸 띄우기

		HttpEntity<MultiValueMap<String, String>> kakaoDataRequest = new HttpEntity<>(headers2);
		// 파싱 받을 dto 만들어야 함
		ResponseEntity<KakaoProfileDto> kakaoDataResponse = rt2.exchange("https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST, kakaoDataRequest, KakaoProfileDto.class);

		KakaoProfileDto account = kakaoDataResponse.getBody();
		UserEntity kakaoUser = UserEntity.builder()
				.username(account.kakaoAccount.profile.nickname + account.id)
				.email(account.kakaoAccount.email)
				.password(account.kakaoAccount.email)
				.phoneNumber("000-0000-0000")
				.role(UserRole.USER)
				.loginType(LoginType.KAKAO)
				.build();
	System.out.println(">>>>>>>>>>>> : " + kakaoUser.getUsername());
		return kakaoUser;
	}
}
