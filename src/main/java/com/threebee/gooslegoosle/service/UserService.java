package com.threebee.gooslegoosle.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.gooslegoosle.dto.ChartDto;
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
	public UserEntity saveUser(UserEntity user) {
		String rawPassword = user.getPassword();
		String bcPassword = bcencoder.encode(rawPassword);
		user.setEnable(true);
		user.setPassword(bcPassword);
		user.setRole(UserRole.USER);
		UserEntity users = iUserRepository.save(user);
		return users;
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

	}

	public UserEntity findId(int id) {
		UserEntity user = iUserRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});
		;
		return user;
	}

	public Page<UserEntity> findAll(String q, Pageable pageable) {
		return iUserRepository.findAll(q, pageable);
	}

	@Transactional
	public UserEntity setWarningUser(int id) {
		UserEntity user = findId(id);
		user.setWarning(user.getWarning() + 1);
		return user;
		
	}

	@Transactional
	public void stopUser(int id) {
		UserEntity user = findId(id);
		user.setEnable(false);
	}

	@Transactional
	public UserEntity unStopUser(int id) {
		UserEntity user = findId(id);
		user.setEnable(true);
		return user;
	}

	public List<ChartDto> lastTwoWeeksUser() {
		return iUserRepository.findLastTwoWeeks();
	}

	
	public UserEntity findId(@NotNull String email) {
		return iUserRepository.findInfo(email).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});
	}
	
	public String getTempPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		String str = "";

		// 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
		int idx = 0;
		for (int i = 0; i < 10; i++) {
			idx = (int) (charSet.length * Math.random());
			str += charSet[idx];
		}
		return str;
	}

	public UserEntity searchPassword(@NotNull(message = "ID는 필수값입니다.") String username, @NotNull String email) {
		
		return null;
	}


}
