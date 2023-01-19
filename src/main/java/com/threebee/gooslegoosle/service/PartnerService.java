package com.threebee.gooslegoosle.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.dto.ChartDto;
import com.threebee.gooslegoosle.dto.PartnerAndStoreDTO;
import com.threebee.gooslegoosle.dto.PartnerFileDTO;
import com.threebee.gooslegoosle.dto.StoreFileDTO;
import com.threebee.gooslegoosle.entity.ImageEntity;
import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IImageReopository;
import com.threebee.gooslegoosle.repository.IMenuRepository;
import com.threebee.gooslegoosle.repository.IPartnerRepository;
import com.threebee.gooslegoosle.repository.IStoreRepository;

@Service
public class PartnerService {

	@Autowired
	private IPartnerRepository iPartnerRepository;
	
	@Autowired
	private IMenuRepository iMenuRepository;

	
	@Value("${file.path}")
	private String uploadFolder;

	@Transactional
	public void savePartner(PartnerFileDTO partner, UserEntity user) {
		UUID uuid = UUID.randomUUID();
		
		String filename = uuid + "_"+partner.getBusinessCard().getOriginalFilename(); 
		
		Path imageFilePath = Paths.get(uploadFolder + filename );
		try {
			Files.write(imageFilePath, partner.getBusinessCard().getBytes());
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PartnerEntity partners = partner.toEntity(filename, user);
		
		partners.setStatus("await");
		iPartnerRepository.save(partners);

	}

	

	@Transactional
	public PartnerEntity findPartnerByUserId(int id) {
		return iPartnerRepository.findByUserId(id);

	}

	@Transactional
	public MenuEntity saveMenu(MenuEntity menu, StoreEntity store) {
		menu.setStore(store);
		MenuEntity menus = iMenuRepository.save(menu);
		return menus;
	}

	@Transactional
	public Page<PartnerEntity> getApplyList(String q , Pageable page) {
		return iPartnerRepository.findAll(q, page);

	}

	@Transactional
	public PartnerEntity findPartnerById(int id) {

		PartnerEntity partner = iPartnerRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다. ");
		});

		return partner;

	}

	@Transactional
	public void setApprove(PartnerEntity partner, UserEntity user) {
		System.out.println("setapprove");
		PartnerEntity editingStore = findPartnerById(partner.getId());
		System.out.println(editingStore);
		editingStore.setUser(user);
		System.out.println("111111111");
		editingStore.setStatus("approve");
		System.out.println("2222222222");

	}

	@Transactional
	public void setDeny(int id) {
		PartnerEntity editingStore = findPartnerById(id);
		editingStore.setStatus("deny");
	}

	@Transactional
	public Page<PartnerEntity> findApprove(Pageable pageable) {
		return iPartnerRepository.findApprove(pageable);
	}
	
	
	@Transactional
	public PartnerEntity findPartnerByPartnerId(int id) {
		return iPartnerRepository.findByPartnerId(id);
	}

	@Autowired
	IStoreRepository iStoreRepository;
	
	@Transactional
	public void setUpload(int id) {
		StoreEntity store =iStoreRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 가게를 찾을 수 없습니다. ");
		});
		
		PartnerEntity partner = findPartnerByPartnerId(store.getPartner().getId());
		partner.setUpload(true);
	}


	@Transactional
	@Modifying
	public void deleteMenu(int id) {
		iMenuRepository.deleteByMenuId(id);
	}



	public List<MenuEntity> findMenuByStoreId(int id) {
		
		return iMenuRepository.findByStoreId(id);
	}



	@Transactional
	public void updateMenu(int id, MenuEntity menu) {
		MenuEntity menus = iMenuRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 메뉴가 없습니다.");
		});
		
		menus.setMenuName(menu.getMenuName());
		menus.setMenuPrice(menu.getMenuPrice());
		
	}


	@Transactional
	public void updateAll(int id, PartnerAndStoreDTO dto) {
		PartnerEntity partner = findPartnerByPartnerId(id);
		partner.setAddress(dto.getAddress());
		partner.setDetailAddress(dto.getDetailAddress());
		partner.setMainNumber(dto.getMainNumber());
		partner.setStoreName(dto.getStoreName());
		
		StoreEntity store = iStoreRepository.findStoreByPartnerId(id);
		store.setBreakTime(dto.getBreakTime());
		store.setCloseTime(dto.getCloseTime());
		store.setOpenTime(dto.getOpenTime());
		store.setCategory(dto.getCategory());
	}



	public List<ChartDto> lastTwoWeeksPartner() {
		
		return iPartnerRepository.findTwoWeeks();
	}

}
