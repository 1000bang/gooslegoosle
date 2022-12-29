package com.threebee.gooslegoosle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.UserService;

@RestController
@RequestMapping("/api")
public class PartnerApiController {

	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/partner/{id}")
	public ResponseDto<Integer> savePartner(@RequestBody PartnerEntity partnerEntity, 
			@PathVariable int id){
		    
		UserEntity user = userService.findId(id);
		
		partnerService.savePartner(partnerEntity, user);
		 
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		
	}
	
	
	@PostMapping("/partner/add_store/{id}")
	public ResponseDto<Integer> saveStore(@RequestBody StoreEntity store, @PathVariable int id){
		
		PartnerEntity storeId = partnerService.findStoreById(id);
		
		partnerService.saveStore(store, storeId);
		
		return new ResponseDto<>(HttpStatus.OK, 1);
		
	}
	

	@PostMapping("/partner/add_menu/{id}")
	public ResponseDto<Integer> saveMenu(@RequestBody MenuEntity menu, @PathVariable int id){
		
		System.out.println(menu+"----------------------------");
		PartnerEntity partner = partnerService.findStoreById(id);
		
		partnerService.saveMenu(menu, partner);

		return new ResponseDto<>(HttpStatus.OK, 1);
		
	}
	
	
	
	
	
	
	
	
}
