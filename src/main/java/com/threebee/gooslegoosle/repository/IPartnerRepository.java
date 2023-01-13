package com.threebee.gooslegoosle.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.threebee.gooslegoosle.dto.ChartDto;
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
	public PartnerEntity findByPartnerId(int id);
	
	@Query(value = "SELECT * FROM partnerentity WHERE status = 'approve'",
			nativeQuery = true)
	public Page<PartnerEntity> findApprove(Pageable pageable);

	
	@Query(value = "SELECT COUNT(*) AS count,  DATE_FORMAT(createTime, '%c/%e') AS date "
			+ "FROM gooslegoosle.PartnerEntity "
			+ "WHERE createTime BETWEEN DATE_ADD(NOW(), INTERVAL -2 WEEK ) AND NOW() "
			+ "GROUP BY date "
			+ "ORDER BY date",
			nativeQuery = true)
	public  List<ChartDto>  findTwoWeeks();

	
	@Query(value = "SELECT * FROM PartnerEntity WHERE storeName LIKE %:item%",
			nativeQuery = true)
	public Page<PartnerEntity> findAll(@Param("item")String q, Pageable page);
	
	
}
