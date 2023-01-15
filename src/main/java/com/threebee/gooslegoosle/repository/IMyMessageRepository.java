package com.threebee.gooslegoosle.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.MessageEntity;

public interface IMyMessageRepository extends JpaRepository<MessageEntity, Integer> {

	
	@Query(value = "SELECT * FROM messageentity WHERE id = ?1 ", nativeQuery = true)
	Page<MessageEntity> findMessage(int id, Pageable pageable);

	@Query(value = "SELECT * FROM messageentity WHERE userId = ?1 ", nativeQuery = true)
	Page<MessageEntity> findMyMessage(int id, Pageable pageable);

	@Query(value = "SELECT * FROM messageentity WHERE userId = ?1 ", nativeQuery = true)
	List<MessageEntity> findAllById(int id);

}
