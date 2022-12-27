package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.model.UserRole;
import com.threebee.gooslegoosle.repository.IUserRepository;

@Service
public class UserService {

	
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcencoder;
	
	
	
		@Transactional
		public int saveUser(UserEntity user) {
			System.out.println(user);
			String rawPassword = user.getPassword();
			String bcPassword = bcencoder.encode(rawPassword);
			user.setPassword(bcPassword);
			user.setRole(UserRole.USER);
			iUserRepository.save(user);
			return 1;
		}

		
	

}
