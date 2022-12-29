package com.threebee.gooslegoosle.api;

import javax.websocket.server.PathParam;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IPartnerRepository;
import com.threebee.gooslegoosle.repository.IStoreRepository;
import com.threebee.gooslegoosle.repository.IUserRepository;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.UserService;

@RestController
@RequestMapping("/api")
public class PartnerApiController {

	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IPartnerRepository partnerRepository;

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IStoreRepository storeRepository;

	
	

	
	@PostMapping("/partner/{id}")
	public ResponseDto<Integer> savePartner(@RequestBody PartnerEntity partnerEntity, 
			@PathVariable int id){
		    
		System.out.println("<<<<<>>>>>>><<<<<>>>>>>"+id);
		UserEntity user = userService.findId(id);
		
		partnerService.savePartner(partnerEntity, user);
		 
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		
	}
	
	
	@PostMapping("/partner/apply_store/{id}")
	public ResponseDto<Integer> saveStore(@RequestBody StoreEntity store, @PathVariable int id){
		
		PartnerEntity storeId = partnerService.findStore(id);
		
		partnerService.saveStore(store, storeId);
		
		
		
		return new ResponseDto<>(HttpStatus.OK, 1);
		
	}
	

	@PostMapping("/partner/apply_menu/{id}")
	public ResponseDto<Integer> saveMenu(@RequestBody MenuEntity menu, @PathVariable int id){
		
		PartnerEntity storeId = partnerService.findStore(id);
		
		partnerService.saveMenu(menu, storeId);
		
		return new ResponseDto<>(HttpStatus.OK, 1);
		
	}
	
	
	
	
	
	
	
	
}
