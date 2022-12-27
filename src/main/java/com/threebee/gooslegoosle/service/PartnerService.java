package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.model.UserRole;
import com.threebee.gooslegoosle.repository.IPartnerRepository;
import com.threebee.gooslegoosle.repository.IUserRepository;

@Service
public class PartnerService {

	@Autowired
	private IPartnerRepository partnerRepository;

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcencoder;

	public int savePartner(@RequestBody UserEntity user) {
		System.out.println(user);
		String rawPassword = user.getPassword();
		String bcPassword = bcencoder.encode(rawPassword);
		user.setPassword(bcPassword);
		user.setRole(UserRole.HOST);
		userRepository.save(user);
//		userRepository.savePartner(bcPassword, bcPassword, bcPassword, bcPassword, bcPassword, rawPassword, bcPassword)
		
		return 1;
	}

}
















