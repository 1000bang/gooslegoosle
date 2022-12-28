package com.threebee.gooslegoosle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.threebee.gooslegoosle.model.CategoryType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class StoreEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@NotNull
	@Column(nullable = false)
	private String storeName;
	
//	@Column(nullable = false, length = 50)
	private String address;
//	
	private String mainnumber;
	
	private int postCode;

	private String extraAddress;

	private String detailAddress;
//	
	@Column(nullable = false, length = 13)
	@NotNull
	@Size(min = 12, max = 14)
	private String phoneNumber;
	
	
	private String status;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	//  이미지 엔티티 넣어야함 
	
	

}
