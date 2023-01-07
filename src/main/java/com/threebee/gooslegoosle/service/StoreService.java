package com.threebee.gooslegoosle.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.threebee.gooslegoosle.dto.StoreFileDTO;
import com.threebee.gooslegoosle.entity.ImageEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IImageReopository;
import com.threebee.gooslegoosle.repository.IStoreRepository;

@Service
public class StoreService {

	@Autowired
	private IStoreRepository storeRepository;

	@Autowired
	private IImageReopository imageReopository;
	
	@Value("${file.path}")
	private String uploadFolder;
	
	public StoreEntity findStoreDetailByStoreId(int id) {
			
		return storeRepository.findStoreDetailById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 가게를 찾을 수 없습니다. ");
		});
	}

	@Transactional
	public Page<StoreEntity> findKorean(String q, Pageable pageable) {
		
		Page<StoreEntity> korea = storeRepository.findKoreaBySearchWord(q, pageable);
		
		return korea;
	}
	public List<StoreEntity> findAll(String q, Pageable pageable) {
		
		List<StoreEntity> store = storeRepository.findAll();
		
		return store;
	}
	@Transactional
	public Page<StoreEntity> findChinese(String q, Pageable pageable) {
		
		Page<StoreEntity> china = storeRepository.findChinaBySearchWord(q, pageable);
		
		return china;
	}
	@Transactional
	public Page<StoreEntity> findJapaness(String q, Pageable pageable) {
		
		Page<StoreEntity> japan = storeRepository.findJapanBySearchWord(q, pageable);
		
		return japan;
	}
	@Transactional
	public Page<StoreEntity> findWestern(String q, Pageable pageable) {
		
		Page<StoreEntity> west = storeRepository.findWestBySearchWord(q, pageable);
		
		return west;
	}
	
	@Transactional
	public StoreEntity saveStore(StoreFileDTO store, PartnerEntity partner) {
		UUID uuid = UUID.randomUUID();
		StoreEntity storeFinal = store.toEntity(partner);
		StoreEntity stores = storeRepository.save(storeFinal);
		
		for (MultipartFile temp : store.getStorePics()) {
			
			String fileName = uuid+"_"+temp.getOriginalFilename();
			ImageEntity storePic = ImageEntity.builder()
					.originFileName(temp.getOriginalFilename())
					.postImageUrl(fileName)
					.store(stores)
					.build();
			imageReopository.save(storePic);
			
			Path imageFilePath = Paths.get(uploadFolder + fileName);
			try {
				Files.write(imageFilePath, temp.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stores;
	}

	public StoreEntity findStoreByStoreId(int id) {
		return storeRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 가게를 찾을 수 없습니다.");
		});
	}

	@Transactional
	public List<String> findReservedStore(UserEntity user) {
		List<String> store = storeRepository.findStoreNameByUserId(user.getId());
		
		return store;
	}

	public StoreEntity findStoreByStoreName(String store) {
		
		return storeRepository.findByStoreName(store);
	}

	@Transactional
	public StoreEntity findByUserId(int id) {
		
		return storeRepository.findStoreByUserId(id);
	}
	
	
	

}
