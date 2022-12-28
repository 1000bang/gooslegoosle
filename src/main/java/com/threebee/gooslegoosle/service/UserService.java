package com.threebee.gooslegoosle.service;

import javax.validation.constraints.NotNull;

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

	public UserEntity searchUserName(@NotNull String username) {

		return iUserRepository.findbyUsername(username).orElseGet(() -> {
			return new UserEntity();
		});

	}

	
	
	
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

	public UserEntity findUserName(String username) {

		return iUserRepository.findbyUsername(username).orElseGet(() -> {
			return new UserEntity();
		});

	}
	
	

	@Transactional
	public void updateUser(UserEntity user) {
		UserEntity userEntity = iUserRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});
		if (user.getPassword() == null || user.getPassword().equals("")) {
			userEntity.setPassword(userEntity.getPassword());
		} else {
			String rawPassword = user.getPassword();
			String encPassword = bcencoder.encode(rawPassword);
			userEntity.setPassword(encPassword);
		}

		userEntity.setUsername(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setAddress(user.getAddress());
		userEntity.setDetailAddress(user.getDetailAddress());
		userEntity.setPostCode(user.getPostCode());
		userEntity.setExtraAddress(user.getExtraAddress());
		userEntity.setPhoneNumber(user.getPhoneNumber());

	}

	@Transactional
	public UserEntity setAdmin(int id) {
		UserEntity userEntity = iUserRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});
		userEntity.setRole(UserRole.ADMIN);
		
		return userEntity;
	}
	
	@Transactional
	public void setHost(int id) {
		System.out.println("sethost");
		UserEntity userEntity = iUserRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});
		userEntity.setRole(UserRole.HOST);
		System.out.println("sethost끝 ");
	}




	public UserEntity findId(int id) {
		UserEntity user = iUserRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});;
		return user;
	}

}
