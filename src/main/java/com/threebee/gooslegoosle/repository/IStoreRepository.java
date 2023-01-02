package com.threebee.gooslegoosle.repository;

import java.util.Optional;

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


}
