package com.threebee.gooslegoosle.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "heart")
public class HeartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int heartId;
	
	@JoinColumn(name = "reviewId")
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private ReviewEntity review;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	public static HeartEntity toLikeEntity(UserEntity userEntity, ReviewEntity reviewEntity){
		HeartEntity heartEntity = new HeartEntity();
		heartEntity.setUser(userEntity);
		heartEntity.setReview(reviewEntity);

        return heartEntity;
    }
	
	
}
