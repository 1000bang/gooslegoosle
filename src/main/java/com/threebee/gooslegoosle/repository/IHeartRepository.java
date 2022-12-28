package com.threebee.gooslegoosle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.HeartEntity;

public interface IHeartRepository extends JpaRepository<HeartEntity, Integer> {
	
	Optional<HeartEntity> findByReview_IdAndUser_Id(int boardId, int memberId);

	void deleteByReview_IdAndUser_Id(int userId, int reviewId);

}
