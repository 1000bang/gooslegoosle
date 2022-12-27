package com.threebee.gooslegoosle.model;

import com.threebee.gooslegoosle.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SocialLogin {

	private ISocialLogin iSocialLogin;
	
	public SocialLogin(ISocialLogin iSocialLogin) {
		this.iSocialLogin = iSocialLogin;
	}
	
	public UserEntity login(String code){
		return iSocialLogin.login(code);
	}
	
} 
