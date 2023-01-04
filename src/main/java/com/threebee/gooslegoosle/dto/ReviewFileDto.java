package com.threebee.gooslegoosle.dto;

import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;

import lombok.Data;

@Data
public class ReviewFileDto {

	private MultipartFile file;
	private String reviewTitle;
	private String reviewContent;
	private String store;
	
	public ReviewEntity toEntity(String postImageUrl, UserEntity user) {
		return ReviewEntity.builder()
							.reviewTitle(reviewTitle)
							.reviewContent(reviewContent)
							.thumbnail(postImageUrl)
							.user(user).build();
	}
	
}
