package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.NoticeEntity;
import com.threebee.gooslegoosle.entity.ServiceCenterEntity;

public interface IServiceRepository extends JpaRepository<ServiceCenterEntity, Integer>{

}
