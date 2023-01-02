package com.threebee.gooslegoosle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.service.ReviewService;

@RestController
public class ReviewApiController {
	
	@Autowired
	private ReviewService reviewService;
	
	
	
	@PutMapping("/api/review/{reviewId}")
	public ResponseDto<Integer> updateReview(@PathVariable int reviewId, @RequestBody ReviewEntity review){
		int result = reviewService.updateReview(reviewId, review);
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}


}
