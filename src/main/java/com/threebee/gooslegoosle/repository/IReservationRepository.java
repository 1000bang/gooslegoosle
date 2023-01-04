package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.ReservationEntity;

public interface IReservationRepository extends JpaRepository<ReservationEntity, Integer> {

}
