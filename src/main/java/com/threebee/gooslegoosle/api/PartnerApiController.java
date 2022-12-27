package com.threebee.gooslegoosle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.dto.PartnerDTO;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.StoreDetailEntity;
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

	// http://localhost:9090/api/partner
	
	@PostMapping("/partner")
	public ResponseDto<Integer> savePartner(@RequestBody StoreEntity storeEntity){
		
//		// 2개 
//		StoreEntity entity = new StoreEntity();
//		entity.setPhoneNumber(partnerDTO.getAddress());
//		
//		// 
//		StoreDetailEntity detailEntity = new StoreDetailEntity();
//		detailEntity.set
		    
		partnerService.savePartner(storeEntity);
		
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		
	}
	
	
}
