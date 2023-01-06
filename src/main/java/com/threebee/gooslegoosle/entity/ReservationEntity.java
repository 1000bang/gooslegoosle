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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
	
	private boolean isReviewd;
	
	@ColumnDefault(" 'wait' ")
	private String approve;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties(value = {"role", "loginType"})
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	private StoreEntity store;
	
	@Override
	public String toString() {
		return "ReservationEntity []";
	}
}
