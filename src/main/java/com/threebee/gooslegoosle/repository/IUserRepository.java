package com.threebee.gooslegoosle.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.dto.ChartDto;
import com.threebee.gooslegoosle.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{


	@Query(value = " SELECT * "
			+ " FROM userentity "
			+ " where username = ?1 "
			, nativeQuery = true)
	Optional<UserEntity> findbyUsername(String username);


	@Query(value = "select count(*) as count,  DATE_FORMAT(createTime, '%c/%e') as date "
			+ "from gooslegoosle.UserEntity "
			+ "where createTime BETWEEN DATE_ADD(NOW(), INTERVAL -2 WEEK ) AND NOW() "
			+ "group by date "
			+ "ORDER BY date"
			, nativeQuery = true)
	 List<ChartDto>  findLastTwoWeeks();
	

	
}
 