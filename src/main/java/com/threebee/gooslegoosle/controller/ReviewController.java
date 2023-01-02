package com.threebee.gooslegoosle.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.repository.IReviewRepository;
import com.threebee.gooslegoosle.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private IReviewRepository iReviewRepository;
	
	

	@GetMapping({ "/reviews", "/review/search" })
	public String fetchShowReview(Model model, @RequestParam(required = false) String search,
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {

		String searchTitle = search == null ? "" : search;
		Page<ReviewEntity> reviews = reviewService.getReviewList(searchTitle.replace("//", ""), pageable);

		int pageBlock = 2;
		int nowPage = reviews.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage - pageBlock, 1);
		int endPage = Math.min(nowPage + pageBlock, reviews.getTotalPages());

		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for (int i = startPage; i <= endPage; i++) {
			pageNumbers.add(i);
		}

		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("search", searchTitle);
		model.addAttribute("reviews", reviews);
		return "review/review_page";
	}

	@GetMapping("/review/{id}")
	public String showReviewDetail(@PathVariable int id, Model model, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		Optional<ReviewEntity> reviewEntity = iReviewRepository.findById(id);
		
		model.addAttribute("reviews", reviewService.reviewDetail(id));
		return "review/review_detail";
	}

	@GetMapping("/review/review_save")
	public String reviewSave() {
		return "/review/review_save";
	}

	@PostMapping("/api/reviews")
	public String save(ReviewEntity review, @AuthenticationPrincipal PrincipalDetail detail) {

		System.out.println(review);
		reviewService.write(review, detail.getUser());

		return "redirect:/reviews";

	}

	@GetMapping("/review/{reviewId}/review_update")
	public String updateReview(@PathVariable int reviewId, Model model) {
		model.addAttribute("review", reviewService.reviewDetail(reviewId));
		return "/review/review_update";
	}

}
