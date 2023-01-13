package com.threebee.gooslegoosle.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.threebee.gooslegoosle.dto.ChartDto;
import com.threebee.gooslegoosle.entity.ReviewEntity;

public interface IReviewRepository extends JpaRepository<ReviewEntity, Integer> {

	@Query(value = "SELECT "
			+ "r.* "
			+ "FROM reviewentity AS r "
			+ "JOIN storeentity AS s "
			+ "JOIN partnerentity AS p "
			+ "ON r.storeId = s.id "
			+ "AND s.partner_id = p.id "
			+ "WHERE p.storeName LIKE %:item% ", 
			countQuery = "SELECT COUNT(*) FROM reviewentity",
			nativeQuery = true)
	Page<ReviewEntity> findByreviewContentContaining(@Param("item")String search, Pageable pageable);
	
	
	@Query(value = " SELECT * "
			+ " FROM reviewentity "
			+ " WHERE userId = ?1 "
			, nativeQuery = true)
	Page<ReviewEntity> myReviewList(int id, Pageable pageable);


	@Query(value = " SELECT * "
			+ " FROM reviewentity "
			+ " WHERE storeId = ?1 "
			, nativeQuery = true)
	Page<ReviewEntity> findAllStoreReview(int id, Pageable pageable);

	@Query(value = "SELECT COUNT(*) AS count,  DATE_FORMAT(createTime, '%c/%e') AS date "
			+ "FROM gooslegoosle.reviewEntity "
			+ "WHERE createTime BETWEEN DATE_ADD(NOW(), INTERVAL -2 WEEK ) AND NOW() "
			+ "GROUP BY date "
			+ "ORDER BY date"
			, nativeQuery = true)
	 List<ChartDto>  findLastTwoWeeks();
	
	
	

}
