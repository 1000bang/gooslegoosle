package com.threebee.gooslegoosle.dto;

import java.awt.Image;

import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.entity.ImageEntity;
import com.threebee.gooslegoosle.entity.MagazineEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PartnerFileDTO {

	private MultipartFile businessCard;
	private String username;
	private String email;
	private String phoneNumber;
	private String storeName;
	private String address;
	private String detailAddress;
	private String mainNumber;
	
	
	
	public PartnerEntity toEntity(String postImageUrl, UserEntity user) {
		return PartnerEntity.builder()
				.storeName(storeName)
				.address(address)
				.detailAddress(detailAddress)
				.mainNumber(mainNumber)
				.phoneNumber(phoneNumber)
				.businessCard(postImageUrl)
				.user(user)
				.build();			
	}

}
