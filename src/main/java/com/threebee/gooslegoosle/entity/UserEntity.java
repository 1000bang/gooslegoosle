package com.threebee.gooslegoosle.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
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

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@Column(nullable = false, length = 10)
	@NotNull
	@Size(min = 2, max = 8)
	private String username;
	
	@Column(nullable = false, length = 100)
	@NotNull
	@Size(min = 4, max = 8)
	private String password;
	
	@Column(nullable = false, length = 13)
	@NotNull
	@Size(min = 12, max = 13)
	private String phoneNumber;
	
	@Column(nullable = false, length = 15)
	@NotNull
	@Email
	private String email;
	
	private String address;
	
	@Enumerated(EnumType.STRING)
	private UserRole role; // user, admin, host
	
	@Enumerated(EnumType.STRING)
	private LoginType loginType; // 이거 만들어야함
	
	@CreationTimestamp
	private Timestamp createdDate;

}
