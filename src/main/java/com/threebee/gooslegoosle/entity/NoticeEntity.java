package com.threebee.gooslegoosle.entity;

import java.sql.Timestamp;
import java.util.List;

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
import javax.persistence.OrderBy;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 1, max = 20, message = "제목은 1자 이상 20자 미만으로 넣어주세요 ")
	@Column(nullable = false, length = 150)
	private String title;

	@Lob 
	private String content;
	
	@ColumnDefault("0") // @Todo 
	private int count;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId") 
	private UserEntity userId;

	@CreationTimestamp
	private Timestamp createDate;

}
