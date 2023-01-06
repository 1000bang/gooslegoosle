package com.threebee.gooslegoosle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.ReservationEntity;

public interface IReservationRepository extends JpaRepository<ReservationEntity, Integer> {

	
	
	@Query(value = "SELECT"
			+ " * FROM reservationentity"
			+ " WHERE storeId = ?1", nativeQuery = true)
	List<ReservationEntity> findByStoreId(int id);

	@Query(value = "SELECT"
			+ " * FROM reservationentity"
			+ " WHERE userId = ?1 ORDER BY id DESC LIMIT 1 ", nativeQuery = true)
	public ReservationEntity findByUserid(int id);

}
