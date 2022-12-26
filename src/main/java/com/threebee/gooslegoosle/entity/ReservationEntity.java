package com.threebee.gooslegoosle.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReservationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;

	@NotNull
	@Column(nullable = false)
	private String date;
	
	@NotNull
	@Column(nullable = false)
	private String time;
	
	@NotNull
	@Column(nullable = false)
	private int headCount;
	
	@Column(nullable = false, length = 13)
	@NotNull
	@Size(min = 12, max = 13)
	private String phoneNumber;
	
	@Lob
	private String request;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "storeId")
	private StoreEntity store;
	
	@OneToMany
	@JoinColumn(name = "menuId")
	private MenuEntity menu;
	

}
