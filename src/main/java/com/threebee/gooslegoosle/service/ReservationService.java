package com.threebee.gooslegoosle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.dto.ChartDto;
import com.threebee.gooslegoosle.entity.ReservationEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IReservationRepository;

@Service
public class ReservationService {

	
	@Autowired
	IReservationRepository reservationRepository;

	@Transactional
	public void saveReservation(ReservationEntity res, UserEntity user, String tid) {
		res.setPhoneNumber(user.getPhoneNumber());
		res.setUser(user);
		res.setReviewd(false);
		res.setTid(tid);
		res.setApprove("Wait");
		reservationRepository.save(res);
	}

	@Transactional
	public void setReviewTrue(int resId) {
		ReservationEntity res = reservationRepository.findById(resId).orElseThrow(()->{
			return new IllegalArgumentException("예약내역이 확인불가");
		});
		
		res.setReviewd(true);
	}
	

	public Page<ReservationEntity> findByUserid(int id, Pageable pageable) {
		return reservationRepository.findByUserId(id, pageable);
	}

	public Page<ReservationEntity> findByStoreId(int id, Pageable pagable) {
		
		return reservationRepository.findByStoreId(id, pagable);
	}

	public List<ChartDto> findByStoreIdWeek(int id) {
		
		return reservationRepository.findByStoreIdForChartWeek(id);
	}
	public List<ChartDto> findByStoreIdMonth(int id) {
		
		return reservationRepository.findByStoreIdForChartMonth(id);
	}
	
	@Transactional
	public void setApprove(String id) {
		int ids = Integer.parseInt(id);
		ReservationEntity res = reservationRepository.findById(ids).orElseThrow(()->{
			return new IllegalArgumentException("해당 예약내역을 찾을 수 없습니다. ");
		});		
		res.setApprove("Approve");
	}
	
	@Transactional
	public void setDeny(String id) {
		int ids = Integer.parseInt(id);
		ReservationEntity res = reservationRepository.findById(ids).orElseThrow(()->{
			return new IllegalArgumentException("해당 예약내역을 찾을 수 없습니다. ");
		});			
		res.setApprove("Deny");
	}

	public ReservationEntity findById(int id) {
		return reservationRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 예약내역을 찾을 수 없습니다. ");
		});			
	}

	@Transactional
	public void setCancle(int id) {
		ReservationEntity res = reservationRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 예약내역을 찾을 수 없습니다. ");
		});			
		res.setApprove("취소 완료");
	}
	
}
