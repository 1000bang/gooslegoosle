package com.threebee.gooslegoosle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.NoticeEntity;
import com.threebee.gooslegoosle.entity.ServiceCenterEntity;
import com.threebee.gooslegoosle.service.NoticeService;
import com.threebee.gooslegoosle.service.ServiceCenterService;


@RestController
public class ServiceApiController {

	@Autowired
	ServiceCenterService serviceCenterService;
	
	
	@PostMapping("/api/service")
	public ResponseDto<Integer> fetchSave(@RequestBody ServiceCenterEntity service,
			@AuthenticationPrincipal PrincipalDetail detail) {
		System.out.println("service : "+ service);
		System.out.println(service);
		serviceCenterService.writeService(service, detail.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	@PutMapping("/api/service/{id}")
	public ResponseDto<Integer>update(@PathVariable int id, @RequestBody ServiceCenterEntity service){
		
		int result = serviceCenterService.modifyService(id, service);
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}
	
	
}
