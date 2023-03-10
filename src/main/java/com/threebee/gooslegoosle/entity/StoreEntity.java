package com.threebee.gooslegoosle.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = {"store"})
	private List<MenuEntity> menu;

	
	@OneToOne
//	@JsonIgnoreProperties({"menu"})
	private PartnerEntity partner;
 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	//  이미지 엔티티 넣어야함 
	@OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"store"})
	private List<ImageEntity> image;
	
	
}
