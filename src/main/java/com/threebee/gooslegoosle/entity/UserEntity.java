package com.threebee.gooslegoosle.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.threebee.gooslegoosle.model.LoginType;
import com.threebee.gooslegoosle.model.UserRole;

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
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	
	@Column(nullable = false, length = 100, unique = true)

	@NotNull
	@Size(min = 2)
	private String username;

	@Column(nullable = false, length = 100)
	@NotNull
	@Size(min = 4, max = 100)
	private String password;

	@Column(nullable = false, length = 100)
	@NotNull
	@Size(min = 12, max = 13)
	private String phoneNumber;
	
	@Column(nullable = false, length = 100) 
	@NotNull
	@Email
	private String email;

	private String address;

	private int postCode;

	private String extraAddress;

	private String detailAddress;

	@Enumerated(EnumType.STRING)
	private UserRole role; // user, admin, host

	@Enumerated(EnumType.STRING)
	private LoginType loginType;

	@CreationTimestamp
	private Timestamp createdDate;

}
