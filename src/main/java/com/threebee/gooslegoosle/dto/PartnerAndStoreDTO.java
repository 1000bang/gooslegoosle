package com.threebee.gooslegoosle.dto;

import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.model.CategoryType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PartnerAndStoreDTO {

	private String storeName; 
	private String mainNumber; 
	private String address; 
	private String detailAddress; 
	private CategoryType category; 
	private String openTime; 
	private String closeTime; 
	private String breakTime; 

	
}
