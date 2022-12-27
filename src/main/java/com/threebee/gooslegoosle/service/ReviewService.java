package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

	@Autowired
	private final ReviewRepository reviewRepository;

	@Transactional
	public Page<ReviewEntity> getReviewList(String search, Pageable pageable) {
		return reviewRepository.findByreviewContentContaining(search, pageable);
	}

	public Object reviewDetail(int id) {
		return reviewRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
	}

}
