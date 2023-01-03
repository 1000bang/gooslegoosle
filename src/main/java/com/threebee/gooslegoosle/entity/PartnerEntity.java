package com.threebee.gooslegoosle.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class PartnerEntity {
	
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
	private String mainNumber;

	private String postcode;
	
	private String detailAddress;
//	
	@Column(nullable = false, length = 13)
	@NotNull
	@Size(min = 12, max = 14)
	private String phoneNumber;
	
	private String status;
	
	private String businessCard;
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "userId")
	private UserEntity user;

	@OneToMany(
			cascade = CascadeType.REMOVE)
	private List<MenuEntity> menu;

	@ColumnDefault("FALSE")
    private Boolean upload;
	

}
