package com.threebee.gooslegoosle.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewApiController {
	
	@GetMapping
	public ResponseEntity<?> reviewSave(){
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
