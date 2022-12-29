package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.PartnerEntity;

public interface IPartnerRepository extends JpaRepository<PartnerEntity, Integer>{


//	@Query(value = " INSERT INTO storeentity "
//			+ " (phoneNumber, storeName, address, postCode) "
//			+ " VALUES (?1, ?2, ?3, ?4 ) ") 
//	public void savePartners(String phoneNumber, String storeName, String address, int postCode);

	@Query(value = " SELECT "
			+ "    * "
			+ " FROM "
			+ "    storeentity "
			+ " WHERE"
			+ "    id = ?1", 			
			nativeQuery = true)
	public PartnerEntity findByID(int id);
	
	
}
