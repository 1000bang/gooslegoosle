package com.threebee.gooslegoosle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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


	@Query(value = "SELECT * FROM storeEntity WHERE partner_id = ?1", nativeQuery = true)
	StoreEntity findStoreByPartnerId(int id);

	@Query(value = "SELECT "
			+ "    s.* "
			+ "FROM "
			+ "    storeEntity AS s "
			+ "        JOIN "
			+ "    PartnerEntity AS p ON s.partner_id = p.id "
			+ "WHERE "
			+ " s.category = 'KOREAN' AND "
			+ "    p.storeName like %:item%", 
			countQuery = "SELECT COUNT(*) FROM storeEntity",
			nativeQuery = true)
	Page<StoreEntity> findKoreaBySearchWord(@Param("item")String q, Pageable pageable);
	
	@Query(value = "SELECT "
			+ "    s.* "
			+ "FROM "
			+ "    storeEntity AS s "
			+ "        JOIN "
			+ "    PartnerEntity AS p ON s.partner_id = p.id "
			+ "WHERE "
			+ " s.category = 'CHINESE' AND "
			+ "    p.storeName like %:item% ", 
			countQuery = "SELECT COUNT(*) FROM storeEntity",
			nativeQuery = true)
	Page<StoreEntity> findChinaBySearchWord(@Param("item")String q, Pageable pageable);
	
	@Query(value = "SELECT "
			+ "    s.* "
			+ "FROM "
			+ "    storeEntity AS s "
			+ "        JOIN "
			+ "    PartnerEntity AS p ON s.partner_id = p.id "
			+ "WHERE "
			+ " s.category = 'JAPANESE' AND "
			+ "    p.storeName like %:item%", 
			countQuery = "SELECT COUNT(*) FROM storeEntity",
			nativeQuery = true)
	Page<StoreEntity> findJapanBySearchWord(@Param("item")String q, Pageable pageable);
	
	@Query(value = "SELECT "
			+ "    s.* "
			+ "FROM "
			+ "    storeEntity AS s "
			+ "        JOIN "
			+ "    PartnerEntity AS p ON s.partner_id = p.id "
			+ "WHERE "
			+ " s.category = 'WESTERN' AND "
			+ "    p.storeName like %:item%", 
			countQuery = "SELECT COUNT(*) FROM storeEntity",
			nativeQuery = true)
	Page<StoreEntity> findWestBySearchWord(@Param("item")String q, Pageable pageable);


	List<StoreEntity> findAll();


}
