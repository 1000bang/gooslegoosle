package com.threebee.gooslegoosle.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.dto.ChartDto;
import com.threebee.gooslegoosle.dto.ChartMonthDTO;
import com.threebee.gooslegoosle.entity.ReservationEntity;

public interface IReservationRepository extends JpaRepository<ReservationEntity, Integer> {

	
	
	@Query(value = "SELECT"
			+ " * FROM reservationentity"
			+ " WHERE storeId = ?1", nativeQuery = true)
	Page<ReservationEntity> findByStoreId(int id, Pageable pageable);

	@Query(value = "SELECT"
			+ " * FROM reservationentity"
			+ " WHERE userId = ?1 ORDER BY id DESC LIMIT 1 ", nativeQuery = true)
	public ReservationEntity findByUserid(int id);

	@Query(value = "SELECT"
			+ " * FROM reservationentity"
			+ " WHERE userId = ?1", nativeQuery = true)
	Page<ReservationEntity> findByUserId(int id, Pageable pageable);

	
	//일주일
	@Query(value = "SELECT count(*) as count, date FROM gooslegoosle.ReservationEntity "
			+ " WHERE "
			+ "    storeid = ?1 "
			+ " AND(date BETWEEN DATE_ADD(NOW(), INTERVAL -1 WEEK ) AND NOW()) "
			+ "GROUP BY date", nativeQuery = true)
	List<ChartDto> findByStoreIdForChartWeek(int id);
	
//	//한달 
//	@Query(value = "SELECT DATE_FORMAT(DATE_SUB(date, INTERVAL (DAYOFWEEK(date)-1) DAY), '%Y/%m/%d') as 'start', "
//			+ "       DATE_FORMAT(DATE_SUB(date, INTERVAL (DAYOFWEEK(date)-7) DAY), '%Y/%m/%d') as 'end', "
//			+ "       DATE_FORMAT(date, '%Y%U') as 'format', "
//			+ "	   		count(date) as count "
//			+ "        "
//			+ "FROM gooslegoosle.ReservationEntity "
//			+ "WHERE  "
//			+ "			    storeid = ?1"
//			+ "			 AND(date BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH ) AND NOW()) "
//			+ "GROUP BY format "
//			+ "order by start ", nativeQuery = true)
//	List<ChartMonthDTO> findByStoreIdForChartMonth(int id);

}
