package com.threebee.gooslegoosle.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.model.CategoryType;
import com.threebee.gooslegoosle.repository.IMenuRepository;
import com.threebee.gooslegoosle.repository.IPartnerRepository;
import com.threebee.gooslegoosle.repository.IStoreRepository;
import com.threebee.gooslegoosle.repository.IUserRepository;

@Service
public class PartnerService {

	@Autowired
	private IPartnerRepository iPartnerRepository;

	@Autowired
	private IStoreRepository iStoreRepository;

	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private IMenuRepository iMenuRepository;
	
	@Autowired
	private BCryptPasswordEncoder bEncoder;

	@Transactional
	public void savePartner(PartnerEntity partner, UserEntity user) {
		partner.setUser(user);
		partner.setStatus("await");
		iPartnerRepository.save(partner);		

	}

	public void saveStore(StoreEntity store, PartnerEntity partner) {
		store.setPartner(partner);
		iStoreRepository.save(store);
		
	}
	
	public PartnerEntity findStoreByUserId(int id) {
		return iPartnerRepository.findByID(id);
		
	}
	
	public void saveMenu(MenuEntity menu, PartnerEntity partner) {
		System.out.println("=========2222=============================");
		menu.setStore(partner);
		iMenuRepository.save(menu);
		System.out.println("======================================");
	}
	
	public Page<PartnerEntity> getApplyList(Pageable page) {
		return iPartnerRepository.findAll(page);
		
	}

	@Transactional
	public PartnerEntity findStoreById(int id) {
		
		PartnerEntity store = iPartnerRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});;
		
		return store;
	
	}

	@Transactional
	public void setApprove(PartnerEntity partner, UserEntity user) {
	System.out.println("setapprove");
		PartnerEntity editingStore =  findStoreById(partner.getId());
		editingStore.setUser(user); 
		editingStore.setStatus("approve");
		
	}
	

	@Transactional
	public void setDeny(int id) {
		PartnerEntity editingStore = findStoreById(id);
		editingStore.setStatus("deny");

	}
}
