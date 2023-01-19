package com.threebee.gooslegoosle.api;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@Value("${mail.id}")
	private String id;

	@Value("${mail.pw}")
	private String pw;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> fetchSave(@Valid @RequestBody UserEntity user) {
		System.out.println("1111111111");
		UserEntity users = userService.saveUser(user);
		MessageEntity newMsg = MessageEntity.builder()
				.comment(users.getUserNickname() + "님 구슬구슬 회원가입을 축하합니다 \n" + "\t\t- 구슬구슬 팀").build();
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
	public ResponseDto<?> fetchFindId(@RequestBody UserEntity user) {
		UserEntity userEntity = userService.fetchFindId(user.getEmail());
		return new ResponseDto<>(HttpStatus.OK, userEntity.getUsername());
	}

	@PostMapping("/auth/findPw")
	public ResponseDto<?> fetchFindPassword(@RequestBody UserEntity user) {
		UserEntity userEntity = userService.fetchFindPassword(user.getEmail(), user.getUsername());

		return new ResponseDto<>(HttpStatus.OK, naverMailSend(userEntity.getId(),userEntity.getEmail()));
	}

	public int naverMailSend(int ids, String email) {
		String host = "smtp.naver.com";
		// 테스트후 개인정보 보안상 비밀번호는 지워주세요

		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties(); // Properties는 java.util의 Properties입니다.
		props.put("mail.smtp.host", host); // smtp의 호스트
		props.put("mail.smtp.port", 587); // 587 포트 사용
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(id, pw);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(id)); // 발신자의 이메일
			// 수신자 이메일
			message.addRecipient(RecipientType.TO, new InternetAddress(email));

			// 메일 제목
			message.setSubject("GoosleGoosle. 임시비밀번호 입니다. ");

			// 메일 내용
			String temporary = userService.fetchPasswordChange(email);
			
			message.setText("안녕하세요.\n 구슬구슬  입니다. \n 임시비밀번호 : " + temporary); // 랜덤인 임시비밀번호를 생성

			// send the message
			Transport.send(message);
			UserEntity user = userService.findId(ids);
			MessageEntity msg = MessageEntity.builder()
					.comment(user.getUserNickname()+"님 임시 비밀번호 변경되었습니다.\n"
							+ "회원 정보 수정을 통해 새비밀번호로 변경해주세요 \n"
							+ "- 구슬구슬 팀")
					.build();
			localMsgService.sendMessageByUserId(user.getId(), msg);
			return 0;
		} catch (MessagingException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
