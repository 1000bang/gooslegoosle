package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.repository.IStoreRepository;

@Service
public class StoreService {

	@Autowired
	private IStoreRepository storeRepository;

	public StoreEntity findStoreDetailByStoreId(int id) {
			
		return storeRepository.findStoreDetailById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 가게를 찾을 수 없습니다. ");
		});
	}

	public Page<StoreEntity> findApprove(Pageable pageable) {
		
		return storeRepository.findAll(pageable);
	}
	
}
