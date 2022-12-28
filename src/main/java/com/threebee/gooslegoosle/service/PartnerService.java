package com.threebee.gooslegoosle.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IPartnerRepository;
import com.threebee.gooslegoosle.repository.IStoreRepository;

@Service
public class PartnerService {

	@Autowired
	private IPartnerRepository partnerRepository;

	@Autowired
	private IStoreRepository storeRepository;

	@Autowired
	private BCryptPasswordEncoder bEncoder;

	@Transactional
	public void savePartner(StoreEntity store, UserEntity user) {

		store.setUser(user);
		partnerRepository.save(store);		

	}
}
