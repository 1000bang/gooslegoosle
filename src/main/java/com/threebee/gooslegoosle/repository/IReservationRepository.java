package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.ReservationEntity;

public interface IReservationRepository extends JpaRepository<ReservationEntity, Integer> {

	@Query(value = "SELECT"
			+ " * FROM reservationentity"
			+ " WHERE userId = ?1 ORDER BY id DESC LIMIT 1 ", nativeQuery = true)
	public ReservationEntity findByid(int id);

}
