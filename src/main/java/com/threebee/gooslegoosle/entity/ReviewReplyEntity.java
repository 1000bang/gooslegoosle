package com.threebee.gooslegoosle.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ReviewReplyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String replyContent;
	
	@ManyToOne
	@JoinColumn(name = "reviewId")
	private ReviewEntity review;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	@CreationTimestamp
	private Timestamp createdDate;

}
