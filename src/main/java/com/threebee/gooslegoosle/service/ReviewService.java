package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.entity.ReviewReplyEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
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

	@Autowired
	private PartnerService partnerService;
	
	@Transactional
	public Page<ReviewEntity> getReviewList(String search, Pageable pageable) {
		return iReviewRepository.findByreviewContentContaining(search, pageable);
	}

	public Object reviewDetail(int id) {
		return iReviewRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
	}

	public int write(ReviewEntity review, UserEntity user) {
		PartnerEntity partner = partnerService.findPartnerById(1);
		review.setStore(partner);
		review.setUser(user);
		review.setStarScore("4");
		 iReviewRepository.save(review);
		return 1; 
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

	@Transactional
	public void deleteReplyById(int replyId, int userId) {
		
		ReviewReplyEntity replyEntity = iReplyRepository.findById(replyId).orElseThrow(() -> {
			return new IllegalArgumentException("해당 댓글을 찾을 수 없네요");
		});
		try {
			int dbWriterInfo = replyEntity.getUser().getId();
			int principalId = userId;
			if(dbWriterInfo == principalId) {
				iReplyRepository.deleteById(replyId);				
			}else {
				throw new IllegalArgumentException("본인 댓글만 삭제가 가능합니다.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}





}
