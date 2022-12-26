package com.threebee.gooslegoosle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<ReviewEntity> getReviewList() {

		return reviewRepository.findAll();
	}

}
