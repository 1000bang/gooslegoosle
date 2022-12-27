package com.threebee.gooslegoosle.model;

import org.springframework.http.ResponseEntity;

import com.threebee.gooslegoosle.entity.UserEntity;

public interface ISocialLogin {

	UserEntity login(String code);
	
}
