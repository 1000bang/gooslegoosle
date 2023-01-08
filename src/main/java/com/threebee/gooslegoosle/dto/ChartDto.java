package com.threebee.gooslegoosle.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public interface ChartDto {

	String getCount();
	String getDate();
	
}
