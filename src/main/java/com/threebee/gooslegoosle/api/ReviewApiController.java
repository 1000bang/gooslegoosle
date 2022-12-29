package com.threebee.gooslegoosle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.entity.ReviewReplyEntity;
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
	
	@DeleteMapping("/api/review/{reviewId}")
	public ResponseDto<Integer> deleteReview(@PathVariable int reviewId){
		System.out.println("들어옴>>>>>>>>>>>>>>>>>>>");
		System.out.println(reviewId);
		reviewService.deleteReview(reviewId);
		System.out.println("들어옴2>>>>>>>>>>>>>>>>>>>");
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	@PostMapping("/api/review/{reviewId}/replySave")
	public ResponseDto<Integer> replySave(@PathVariable int reviewId,@RequestBody ReviewReplyEntity reqReply,
			@AuthenticationPrincipal PrincipalDetail principalDetail){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(reqReply.getReplyContent());
		reviewService.writeReply(reviewId, reqReply, principalDetail.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK,1);
	}


}
