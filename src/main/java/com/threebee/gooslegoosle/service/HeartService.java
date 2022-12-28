package com.threebee.gooslegoosle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.gooslegoosle.entity.HeartEntity;
import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IHeartRepository;
import com.threebee.gooslegoosle.repository.IUserRepository;
import com.threebee.gooslegoosle.repository.IReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeartService {
	
	@Autowired
	private IHeartRepository heartRepository;
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private IReviewRepository reviewRepository;
	
	@Transactional
	public int findLike(int reviewId, int userId) {
		Optional<HeartEntity> heartLike = heartRepository.findByReview_IdAndUser_Id(reviewId, userId);
		if(heartLike.isEmpty()) {
			return 0;
		}
		return 1;
	}
	
	@Transactional
	public int saveLike(int reviewId, int userId) {
		Optional<HeartEntity> heartLike = heartRepository.findByReview_IdAndUser_Id(reviewId, userId);
		
		System.out.println(heartLike.isEmpty());
		
		 if (heartLike.isEmpty()){
	            UserEntity userEntity = iUserRepository.findById(userId).get();
	            ReviewEntity reviewEntity = reviewRepository.findById(reviewId).get();

	            HeartEntity heartEntity = HeartEntity.toLikeEntity(userEntity, reviewEntity);
	            heartRepository.save(heartEntity);
//	            reviewRepository.plusLike(reviewId);
	            return 1;
	        }else {
	        	heartRepository.deleteByReview_IdAndUser_Id(userId, reviewId);
//	        	reviewRepository.minusLike(reviewId);
	            return 0;
	        }
	}

}
