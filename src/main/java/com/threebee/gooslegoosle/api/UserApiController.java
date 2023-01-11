package com.threebee.gooslegoosle.api;

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
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.dto.exception.ErrorResponse;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.UserService;
 
@RestController
public class UserApiController {

	@Autowired
	UserService userService;     
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody UserEntity user) {
		userService.saveUser(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}    
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PutMapping("/api/user")
	public ResponseDto<Integer> update(@RequestBody UserEntity user){
		
		//validation처리 예외잡아서 사용자한테 떨궈주면 됨 
		userService.updateUser(user);
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		//2. 컨텍스트 홀더에 밀어넣기
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	
	
}
