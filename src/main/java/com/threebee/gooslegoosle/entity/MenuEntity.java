package com.threebee.gooslegoosle.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class MenuEntity {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String menuName;
	
	@NotNull
	@Column(nullable = false)
	private int menuPrice;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "storeId")
	private StoreEntity store;

	
}
