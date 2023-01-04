package com.threebee.gooslegoosle.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.ReviewEntity;

public interface IReviewRepository extends JpaRepository<ReviewEntity, Integer> {

	Page<ReviewEntity> findByreviewContentContaining(String search, Pageable pageable);
	
	
	@Query(value = " SELECT * "
			+ " FROM reviewentity "
			+ " WHERE userId = ?1 "
			, nativeQuery = true)
	Page<ReviewEntity> myReviewList(int id, Pageable pageable);


	@Query(value = " SELECT * "
			+ " FROM reviewentity "
			+ " WHERE storeId = ?1 "
			, nativeQuery = true)
	Page<ReviewEntity> findAllStoreReview(int id, Pageable pageable);
	
	
	

}
