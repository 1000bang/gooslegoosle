package com.threebee.gooslegoosle.service;

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
	

	public ReservationEntity findid(int id) {
		return reservationRepository.findByid(id);
	}
	
	
	
}
