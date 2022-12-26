package com.threebee.gooslegoosle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/review")
	public String fetchShowReview(Model model) {

		List<ReviewEntity> reviews = reviewService.getReviewList();
		model.addAttribute("reviews", reviews);
		return "review/reviewPage";
	}

}
