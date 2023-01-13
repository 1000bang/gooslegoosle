package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.ReviewReplyEntity;

public interface IReplyRepository extends JpaRepository<ReviewReplyEntity, Integer>{

}
