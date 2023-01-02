package com.threebee.gooslegoosle.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.MagazineFileDTO;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.MagazineEntity;
import com.threebee.gooslegoosle.entity.NoticeEntity;
import com.threebee.gooslegoosle.service.MagazineService;
import com.threebee.gooslegoosle.service.NoticeService;


@RestController
public class MagazineApiController {

	@Autowired
	MagazineService magazineService;
	
	
	@PostMapping("/api/magazine")
	public ResponseDto<Integer> fetchSave(MagazineFileDTO file, 
			@AuthenticationPrincipal PrincipalDetail detail) {
		System.out.println(detail);
		System.out.println("file >>>>>>>"+ file.getFile().getOriginalFilename());
		magazineService.writeMagazine(file, detail.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	@PutMapping("/api/magazine/{id}")
	public ResponseDto<Integer>update(@PathVariable int id, @RequestBody MagazineEntity magazine){
		
		int result = magazineService.modifyMagazine(id, magazine);
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}
	
	
	
	
}
