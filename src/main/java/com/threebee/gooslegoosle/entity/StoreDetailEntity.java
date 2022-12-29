package com.threebee.gooslegoosle.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.threebee.gooslegoosle.model.CategoryType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class StoreDetailEntity {
	
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
	
	@OneToOne
	private StoreEntity store;
	
}
