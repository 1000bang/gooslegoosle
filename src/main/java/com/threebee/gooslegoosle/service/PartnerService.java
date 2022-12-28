package com.threebee.gooslegoosle.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.StoreDetailEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.model.CategoryType;
import com.threebee.gooslegoosle.repository.IMenuRepository;
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
	private IMenuRepository menuRepository;
	
	@Autowired
	private BCryptPasswordEncoder bEncoder;

	@Transactional
	public void savePartner(StoreEntity store, UserEntity user) {
		store.setUser(user);
		store.setStatus("await");
		partnerRepository.save(store);		

	}

	public void saveStore(StoreDetailEntity store, StoreEntity storeId) {
		store.setStore(storeId);
		storeRepository.save(store);
		
	}
	
	public StoreEntity findStoreByUserId(int id) {
		return partnerRepository .findByID(id);
		
	}
	
	public void saveMenu(MenuEntity menu, StoreEntity storeId) {
		menu.setStore(storeId);
		menuRepository.save(menu);
		
	}
	
	public Page<StoreEntity> getApplyList(Pageable page) {
		return partnerRepository.findAll(page);
		
	}

	public StoreEntity findStore(int id) {
		
		StoreEntity store = partnerRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});;
		
		return store;
	
	}

	@Transactional
	public void setApprove(StoreEntity store, UserEntity user) {
	System.out.println("setapprove");
		StoreEntity editingStore =  findStore(store.getId());
		editingStore.setUser(user);
		editingStore.setStatus("approve");
		System.out.println(">>>>store :" +editingStore);
		
	}
	

	@Transactional
	public void setDeny(int id) {
		StoreEntity editingStore = findStore(id);
		editingStore.setStatus("deny");

	}
}
