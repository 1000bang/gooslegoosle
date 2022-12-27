package com.threebee.gooslegoosle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.UserService;

@RestController
@RequestMapping("/auth")
public class PartnerApiController {

	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private UserService  userService;
	
	@PostMapping("/partner")
	public ResponseDto<Integer> savePartner(@RequestBody UserEntity userEntity){
		partnerService.savePartner(userEntity);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	
	
}
