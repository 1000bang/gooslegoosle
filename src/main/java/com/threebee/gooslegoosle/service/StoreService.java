package com.threebee.gooslegoosle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.StoreDetailEntity;
import com.threebee.gooslegoosle.repository.IStoreRepository;

@Service
public class StoreService {

	@Autowired
	private IStoreRepository storeRepository;

	public StoreDetailEntity findStoreDetailByStoreId(int id) {
			
		return storeRepository.findStoreDetailById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 가게를 찾을 수 없습니다. ");
		});
	}
	
}
