package com.threebee.gooslegoosle.api;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IPartnerRepository;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.UserService;

@RestController
@RequestMapping("/api")
public class PartnerApiController {

	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private IPartnerRepository partnerRepository;

	@Autowired
	UserService userService;
	
	@PostMapping("/partner/{id}")
	public ResponseDto<Integer> savePartner(@RequestBody StoreEntity storeEntity, 
			@PathVariable int id){
		    
		System.out.println(id);
		UserEntity user = userService.findbyid(id);
		
		partnerService.savePartner(storeEntity, user);
		 
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		
	}
	
	
}
