package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.ImageEntity;

public interface IImageReopository extends JpaRepository<ImageEntity, Integer> {
	

}
