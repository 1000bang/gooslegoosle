package com.threebee.gooslegoosle.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.threebee.gooslegoosle.converter.StringListConverter;
import com.threebee.gooslegoosle.model.CategoryType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private CategoryType category; // KOREAN, JAPANESE, CHINESE, WESTERN

	@NotNull
	@Column(nullable = false)
	private String openTime;
	
	private String breakTime;
	
	@NotNull
	@Column(nullable = false)
	private String closeTime;
	
	@OneToMany
	@JoinColumn(name = "menuList")
	private List<MenuEntity> menu;
	
//	@Convert(converter = StringListConverter.class)
	@ElementCollection
	private List<String> storePics = new ArrayList<>();
	
	@OneToOne
	private PartnerEntity partner;

	
	private String status;
	
	@ColumnDefault("FALSE")
	private Boolean upload;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	//  이미지 엔티티 넣어야함 
	

}
