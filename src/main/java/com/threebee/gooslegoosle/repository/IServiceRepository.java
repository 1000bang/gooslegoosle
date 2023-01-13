package com.threebee.gooslegoosle.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.NoticeEntity;
import com.threebee.gooslegoosle.entity.ServiceCenterEntity;

public interface IServiceRepository extends JpaRepository<ServiceCenterEntity, Integer>{

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM serviceCenterEntity WHERE id = ?1", nativeQuery =  true)
	void deleteByIds(int id);

	@Query(value = "SELECT * FROM serviceCenterEntity WHERE userId = ?1", nativeQuery =  true)
	Page<ServiceCenterEntity> findByUserId(int id, Pageable pageable);

}
