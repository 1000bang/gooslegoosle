package com.threebee.gooslegoosle.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

	Page<ReviewEntity> findByreviewContentContaining(String search, Pageable pageable);

//	List<ReviewEntity> findByreviewContentContaining();
}
