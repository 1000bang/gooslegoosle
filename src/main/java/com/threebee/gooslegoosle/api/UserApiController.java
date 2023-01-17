package com.threebee.gooslegoosle.api;

import java.util.Properties;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.MessageEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.MessageService;
import com.threebee.gooslegoosle.service.UserService;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
public class UserApiController {

	@Autowired
	UserService userService;

	private DefaultMessageService messageService;

	@Autowired
	private MessageService localMsgService;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> fetchSave(@RequestBody UserEntity user) {
		UserEntity users = userService.saveUser(user);
		MessageEntity newMsg = MessageEntity.builder()
		.comment(users.getUserNickname()+"님 구슬구슬 회원가입을 축하합니다 \n"
				+ "\t\t- 구슬구슬 팀")
		.build();
		localMsgService.sendMessageByUserId(users.getId(), newMsg);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	@Autowired
	private AuthenticationManager authenticationManager;

	@PutMapping("/api/user")
	public ResponseDto<Integer> fetchUpdate(@RequestBody UserEntity user) {

		// validation처리 예외잡아서 사용자한테 떨궈주면 됨
		userService.updateUser(user);
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		// 2. 컨텍스트 홀더에 밀어넣기
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	@GetMapping("/auth/check")
	public String fetchSMS(String phoneNumber) {
		System.out.println("123");
		Random rand = new Random();
		String numStr = "";
		for (int i = 0; i < 4; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}

		System.out.println("수신자 번호 : " + phoneNumber);
		System.out.println("인증번호 : " + numStr);
		certifiedPhoneNumber(phoneNumber, numStr);
		return numStr;
	}

	public void certifiedPhoneNumber(String phoneNumber, String numStr) {
		messageService = NurigoApp.INSTANCE.initialize("NCSJQVU63UFNIHKW", "H9TT57VRBXM65BEA0DOEO37IATDN1JKX",
				"https://api.coolsms.co.kr");

		Message message = new Message();
		// 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
		message.setFrom("01094110807");
		message.setTo(phoneNumber);
		message.setText("구슬구슬 휴대폰인증 : 인증번호는[" + numStr + "] 입니다.");

		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
		System.out.println(response);

	}
	
	// 아이디 찾기
	@PostMapping("/auth/find")
	public  ResponseDto<?> fetchFindId(@RequestBody UserEntity user){
		UserEntity userEntity = userService.findId(user.getEmail());
		return new ResponseDto<>(HttpStatus.OK, userEntity.getUsername());
	}
	
	@PostMapping("/auth/findPw")
	public  ResponseDto<?> fetchFindPassword(@RequestBody UserEntity user){
		UserEntity userEntity = userService.searchPassword(user.getUserNickname(),user.getEmail());
		return new ResponseDto<>(HttpStatus.OK, userEntity.getUsername());
	}
	
	
	

}
