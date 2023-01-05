package com.threebee.gooslegoosle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.ReservationEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IReservationRepository;

@Service
public class ReservationService {

	
	@Autowired
	IReservationRepository reservationRepository;

	@Transactional
	public void saveReservation(ReservationEntity res, UserEntity user) {
		res.setPhoneNumber(user.getPhoneNumber());
		res.setUser(user);
		res.setReviewd(false);

		
		reservationRepository.save(res);
	}

	@Transactional
	public void setReviewTrue(int resId) {
		ReservationEntity res = reservationRepository.findById(resId).orElseThrow(()->{
			return new IllegalArgumentException("예약내역이 확인불가");
		});
		
		res.setReviewd(true);
	}
	

	public ReservationEntity findid(int id) {
		return reservationRepository.findByid(id);
	}

	public List<ReservationEntity> findByStoreId(int id) {
		
		return reservationRepository.findByStoreId(id);
	}
	
	
	
}
