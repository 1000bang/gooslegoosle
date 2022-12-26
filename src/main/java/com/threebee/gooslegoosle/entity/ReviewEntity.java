package com.threebee.gooslegoosle.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class ReviewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@Lob
	@NotNull
	private String content;
	
	@Column(nullable = false, length = 50)
	private String starScore;
	
	private UserEntity user;

}
