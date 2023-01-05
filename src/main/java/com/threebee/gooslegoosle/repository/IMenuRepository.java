package com.threebee.gooslegoosle.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.MenuEntity;

public interface IMenuRepository extends JpaRepository<MenuEntity, Integer>{

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM MenuEntity "
			+ "WHERE "
			+ "    id = ?1", nativeQuery = true )
	void deleteByMenuId(int id);

	
	@Query(value = "SELECT "
			+ "    * "
			+ "FROM "
			+ "    menuEntity "
			+ "WHERE "
			+ "    storeId = ?1", nativeQuery = true)
	List<MenuEntity> findByStoreId(int id);

}
