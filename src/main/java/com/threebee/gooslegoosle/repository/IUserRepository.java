package com.threebee.gooslegoosle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{


	@Query(value = " SELECT * "
			+ " FROM userentity "
			+ " where username = ?1 "
			, nativeQuery = true)
	Optional<UserEntity> findbyUsername(String username);
	
//	@Query(value = " INSERT INTO userentity (address, createdDate, email, "
//			+ " loginType, password, phoneNumber, "
//			+ " role, username) VALUES ( ?, now(), ? , ?, ?, ? "
//			+ " ?, ?) "
//			,nativeQuery = true)
//	Optional<UserEntity> savePartner(String address,
//			String email, String loginType, String password, String phoneNumber,
//			String role, String username);

}
 