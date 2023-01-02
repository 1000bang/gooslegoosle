package com.threebee.gooslegoosle.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
			+ " userId = ?1", 			
			nativeQuery = true)
	public PartnerEntity findByUserId(int id);
	
	@Query(value = " SELECT "
			+ " * "
			+ " FROM "
			+ " partnerentity "
			+ " WHERE"
			+ " id = ?1", 			
			nativeQuery = true)
	public PartnerEntity findByStoreId(int id);
	
	@Query(value = "SELECT * FROM partnerentity WHERE status = 'approve'",
			nativeQuery = true)
	public Page<PartnerEntity> findApprove(Pageable pageable);
	
	
}
