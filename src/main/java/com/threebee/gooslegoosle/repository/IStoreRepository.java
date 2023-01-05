package com.threebee.gooslegoosle.repository;

import java.util.List;
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
			+ "   id = ?1 ", nativeQuery = true)
	Optional<StoreEntity> findStoreDetailById(int id);

	
	@Query(value = "SELECT * FROM storeEntity as s, partnerEntity as p WHERE p.id = s.partner_id AND p.status = 'approve'",
			nativeQuery = true)
	Page<StoreEntity> findApprove(Pageable pageable);


	@Query(value = "SELECT "
			+ "    p.storeName, r.id "
			+ "FROM "
			+ "    reservationEntity AS r "
			+ "        JOIN "
			+ "    storeEntity AS s "
			+ "        JOIN "
			+ "    partnerEntity AS p "
			+ "WHERE "
			+ "    r.storeid = s.id AND p.id = s.partner_id "
			+ "     AND r.isReviewd = false AND r.userid = ?1", nativeQuery = true)
	List<String> findStoreNameByUserId(int id);


	@Query(value = "SELECT "
			+ "    * "
			+ "FROM "
			+ "    storeEntity AS s, "
			+ "    PartnerEntity AS p "
			+ "WHERE "
			+ "    s.partner_id = p.id "
			+ "        AND p.storeName = ?1", nativeQuery = true)
	StoreEntity findByStoreName(String store);


	
	@Query(value = "SELECT * FROM storeEntity WHERE userId = ?1", nativeQuery = true)
	StoreEntity findStoreByUserId(int id);


}
