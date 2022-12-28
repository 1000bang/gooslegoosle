package com.threebee.gooslegoosle.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IPartnerRepository;
import com.threebee.gooslegoosle.repository.IStoreRepository;
import com.threebee.gooslegoosle.repository.IUserRepository;

@Service
public class PartnerService {

	@Autowired
	private IPartnerRepository partnerRepository;

	@Autowired
	private IStoreRepository storeRepository;

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bEncoder;

	@Transactional
<<<<<<< HEAD
	public void savePartner(StoreEntity store, UserEntity user) {

		store.setUser(user);
=======
	public void savePartner(StoreEntity store) {
		store.setStatus("await");
>>>>>>> df98b14c380bd1b822a32ece556468716f34c8d1
		partnerRepository.save(store);		

	}

	
	
	
	public Page<StoreEntity> getApplyList(Pageable page) {
		return partnerRepository.findAll(page);
		
	}




	public StoreEntity findStore(int id) {
		StoreEntity store = partnerRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 가게를 찾을 수 없습니다. ");
		});
	
		return store;
		
		
	}

	@Transactional
	public void setApprove(StoreEntity store, UserEntity user) {
	System.out.println("setapprove");
		StoreEntity editingStore =  findStore(store.getId());
		editingStore.setStatus("approve");
		editingStore.setUser(user);
		System.out.println("setapprov 끝  ");
	}
}
