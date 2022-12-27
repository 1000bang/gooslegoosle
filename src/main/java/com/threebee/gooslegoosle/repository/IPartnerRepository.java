package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.dto.PartnerDTO;
import com.threebee.gooslegoosle.entity.StoreEntity;

public interface IPartnerRepository extends JpaRepository<StoreEntity, Integer>{


//	@Query(value = " INSERT INTO storeentity "
//			+ " (phoneNumber, storeName, address, postCode) "
//			+ " VALUES (?1, ?2, ?3, ?4 ) ") 
//	public void savePartners(String phoneNumber, String storeName, String address, int postCode);

}
