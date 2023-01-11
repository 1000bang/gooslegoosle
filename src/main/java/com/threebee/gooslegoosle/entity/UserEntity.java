package com.threebee.gooslegoosle.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.threebee.gooslegoosle.model.LoginType;
import com.threebee.gooslegoosle.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(nullable = false, length = 100, unique = true)
	@NotNull(message = "ID는 필수값입니다.")
	@Size(min = 2, message = "ID가 너무 짧습니다. ")
	private String username;

	@Column(nullable = false, length = 100)
	@NotNull
	@Size(min = 2)
	private String userNickname;
	
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
	
	@ColumnDefault("True")
	private boolean isEnable;

	private String address;

	private int postCode;

	private String extraAddress;

	private String detailAddress; 
	@ColumnDefault("0")
	private int warning;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = {"user"})
	private List<ReservationEntity> reservation;

	@Enumerated(EnumType.STRING)
	private UserRole role; // user, admin, host

	@Enumerated(EnumType.STRING)
	private LoginType loginType;

	@CreationTimestamp
	private Timestamp createdDate;

	@Override
	public String toString() {
		return "UserEntity []";
	}
	
	@CreationTimestamp
	private Timestamp createTime;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = {"user"})
	private List<MessageEntity> message;
	
}
