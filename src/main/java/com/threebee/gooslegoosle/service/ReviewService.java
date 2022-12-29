package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.entity.ReviewReplyEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IReplyRepository;
import com.threebee.gooslegoosle.repository.IReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

	@Autowired
	private final IReviewRepository iReviewRepository;
	
	@Autowired
	private final IReplyRepository iReplyRepository;

	@Transactional
	public Page<ReviewEntity> getReviewList(String search, Pageable pageable) {
		return iReviewRepository.findByreviewContentContaining(search, pageable);
	}

	public Object reviewDetail(int id) {
		return iReviewRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
	}

	public void write(ReviewEntity review, UserEntity user) {
		review.setId(review.getId());
		review.setUser(user);
		review.setStarScore("4");
		iReviewRepository.save(review);
		
	}

	@Transactional
	public int updateReview(int id, ReviewEntity review) {
		
		ReviewEntity reviewEntity = iReviewRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없네요");
		});
		reviewEntity.setReviewTitle(review.getReviewTitle());
		reviewEntity.setReviewContent(review.getReviewContent());
		return 1;
	}

	@Transactional
	public void deleteReview(int reviewId) {
		iReviewRepository.deleteById(reviewId);
	}

	@Transactional
	public void writeReply(int reviewId, ReviewReplyEntity reqReply, UserEntity user) {
		
		ReviewEntity review = iReviewRepository.findById(reviewId).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없네요");
		});
		
		reqReply.setReview(review);
		reqReply.setUser(user);
		iReplyRepository.save(reqReply);
	}



}
