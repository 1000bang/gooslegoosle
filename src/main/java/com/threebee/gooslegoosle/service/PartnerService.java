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
	public void savePartner(StoreEntity store, UserEntity user) {
		store.setStatus("await");
		partnerRepository.save(store);		

	}

	
	
	
	public Page<StoreEntity> getApplyList(Pageable page) {
		return partnerRepository.findAll(page);
		
	}




	public StoreEntity findStore(int id) {
		StoreEntity store = partnerRepository.findByID(id);
		
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



	@Transactional
	public void setDeny(int id) {
		StoreEntity editingStore = findStore(id);
		editingStore.setStatus("deny");

	}
}
