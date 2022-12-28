package com.threebee.gooslegoosle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ReviewEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull
	private int id;
	
//	@NotNull
	@Column(nullable = false, length = 15)
	private String reviewTitle;
	
	@Lob
	private String reviewContent;
	
	@Column(nullable = false, length = 50)
//	@NotNull
	private String starScore;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "storeId")
	private StoreEntity store;
	
	


}
