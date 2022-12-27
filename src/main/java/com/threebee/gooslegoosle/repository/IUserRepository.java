package com.threebee.gooslegoosle.repository;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{


	@Query(value = " SELECT * "
			+ " FROM userentity "
			+ " where username = ?1 "
			, nativeQuery = true)
	Optional<UserEntity> findbyUsername(String username);

	
}
 