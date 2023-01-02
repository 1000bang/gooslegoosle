package com.threebee.gooslegoosle.dto;

import java.awt.Image;

import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.entity.ImageEntity;
import com.threebee.gooslegoosle.entity.MagazineEntity;
import com.threebee.gooslegoosle.entity.UserEntity;

import lombok.Data;

@Data
public class FileDTO {

	private MultipartFile file;
	private String title;
	private String content;
	
	public MagazineEntity toEntity(String postImageUrl, UserEntity user) {
		return MagazineEntity.builder()
				.title(title).content(content).thumbnail(postImageUrl).userId(user).build();
				
	}

}
