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
import com.threebee.gooslegoosle.service.NoticeService;


@RestController
public class NoticeApiController {

	@Autowired
	NoticeService noticeservice;
	
	
	@PostMapping("/api/notice")
	public ResponseDto<Integer> fetchSave(@RequestBody NoticeEntity notice,
			@AuthenticationPrincipal PrincipalDetail detail) {
		System.out.println("notice : "+ notice);
		System.out.println(notice);
		noticeservice.writeNotice(notice, detail.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	@PutMapping("/api/notice/{id}")
	public ResponseDto<Integer>update(@PathVariable int id, @RequestBody NoticeEntity notice){
		
		int result = noticeservice.modifyNotice(id, notice);
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}
	
	
}
