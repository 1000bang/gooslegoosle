package com.threebee.gooslegoosle.dto;

import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.entity.UserEntity;

import lombok.Data;

@Data
public class ReviewFileDto {

	private MultipartFile file;
	private String title;
	private String content;
	
	public ReviewEntity toEntity(String postImageUrl, ReviewEntity review) {
		return ReviewEntity.builder()
							.reviewTitle(title)
							.reviewContent(content)
							.thumbnail(postImageUrl)
							.user(review.getUser()).build();
	}
	
}
