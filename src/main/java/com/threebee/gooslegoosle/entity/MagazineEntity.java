package com.threebee.gooslegoosle.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.threebee.gooslegoosle.dto.MagazineFileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MagazineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@Column(nullable = false, length = 150)
	private String title;

	@Lob 
	private String content;
	
	@ColumnDefault("0") // @Todo 
	private int count;

	private String thumbnail;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId") 
	private UserEntity userId;

	@CreationTimestamp
	private Timestamp createDate;
	
}
