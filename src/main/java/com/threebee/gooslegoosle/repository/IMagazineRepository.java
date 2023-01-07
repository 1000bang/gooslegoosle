package com.threebee.gooslegoosle.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.MagazineEntity;

public interface IMagazineRepository extends JpaRepository<MagazineEntity, Integer> {

	Page<MagazineEntity> findAll(Pageable pageable);

}
