package com.threebee.gooslegoosle.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.entity.ImageEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.model.CategoryType;

import lombok.Data;
@Data
public class StoreFileDTO {

	private MultipartFile[] storePics;
	private CategoryType category;
	private String openTime;
	private String breakTime;
	private String closeTime;
	private PartnerEntity partner;
	
	
	
	public StoreEntity toEntity(PartnerEntity partner) {
		return StoreEntity.builder()
				.category(category)
				.breakTime(breakTime)
				.closeTime(closeTime)
				.openTime(openTime)
				.partner(partner)
				.user(partner.getUser())
				.image(null)
				.build();
	
			
				
	}
	
}
