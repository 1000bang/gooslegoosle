package com.threebee.gooslegoosle.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.ReviewEntity;

public interface IReviewRepository extends JpaRepository<ReviewEntity, Integer> {

	Page<ReviewEntity> findByreviewContentContaining(String search, Pageable pageable);

//	void plusLike(int reviewId);
//
//	void minusLike(int reviewId);
	

}
