package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.PartnerEntity;

public interface IPartnerRepository extends JpaRepository<PartnerEntity, Integer>{

	@Query(value = 
			" SELECT "
			+ " * "
			+ " FROM "
			+ " partnerentity "
			+ " WHERE"
			+ " id = ?1", 			
			nativeQuery = true)
	public PartnerEntity findByID(int id);
	
	
}
