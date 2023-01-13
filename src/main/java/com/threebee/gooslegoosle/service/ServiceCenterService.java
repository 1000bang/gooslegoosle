package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.gooslegoosle.entity.ServiceCenterEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IServiceRepository;



@Service
public class ServiceCenterService {

	@Autowired
	IServiceRepository serviceRepository;
	
	public void writeService(ServiceCenterEntity serviceCenter, UserEntity user) {
		serviceCenter.setCount(0);
		serviceCenter.setUserId(user);
		serviceRepository.save(serviceCenter);
	}
	
	@Transactional
	public Page<ServiceCenterEntity> getServiceList(Pageable pageable) {

		return serviceRepository.findAll(pageable);
	}
	
	@Transactional
	public ServiceCenterEntity getServiceDetail(int id) {
		return serviceRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
	}

	@Transactional
	public int modifyService(int id, ServiceCenterEntity service) {
		ServiceCenterEntity boardEntity = serviceRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
		boardEntity.setTitle(service.getTitle());
		boardEntity.setContent(service.getContent());
		return 1;
	}

	public void deleteServiceById(int id) {
		serviceRepository.deleteByIds(id);
	}

	public Page<ServiceCenterEntity> getServiceMyList(int id, Pageable pageable) {
		
		return serviceRepository.findByUserId(id, pageable);
	}
	
	
}
