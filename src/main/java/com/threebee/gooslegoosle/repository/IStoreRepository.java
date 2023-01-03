package com.threebee.gooslegoosle.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.StoreEntity;

public interface IStoreRepository extends JpaRepository<StoreEntity, Integer>{

	@Query(value = "SELECT "
			+ "    * "
			+ "FROM "
			+ "    StoreEntity "
			+ "WHERE "
			+ "   partner_id = ?1 ", nativeQuery = true)
	Optional<StoreEntity> findStoreDetailById(int id);

	
	@Query(value = "SELECT * FROM storeEntity as s, partnerEntity as p WHERE p.id = s.partner_id AND p.status = 'approve'",
			nativeQuery = true)
	Page<StoreEntity> findApprove(Pageable pageable);


}
