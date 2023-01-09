package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.threebee.gooslegoosle.entity.ServiceCenterEntity;
import com.threebee.gooslegoosle.service.ServiceCenterService;

@Controller
public class ServiceCenterController {
	
	@Autowired
	ServiceCenterService serviceCenter;
	
	@GetMapping("/seviceCenter")
	public String fetchServiceList(Model model,
			@PageableDefault(size = 6, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		Page<ServiceCenterEntity> service = serviceCenter.getServiceList(pageable);
	
		model.addAttribute("services", service);
		return "service_center/service_center";
	}	
	
	@GetMapping("/seviceCenter/{id}")
	public String fetchServiceDetail(@PathVariable int id, Model model) {
		
		model.addAttribute("services", serviceCenter.getServiceDetail(id));
		return "/service_center/service_center_detail"; // 페이지 만들어야함
	}

	
	@GetMapping("/seviceCenter/board")
	public String fetchService() {
		
		return "/service_center/service_center_save"; // 페이지 만들어야함
	}

	@GetMapping("/service_center/update/{id}")
	public String fetchServiceUpdate(@PathVariable int id, Model model) {
		ServiceCenterEntity service = serviceCenter.getServiceDetail(id);
		model.addAttribute("services", service);
		return "/service_center/service_center_update"; // 페이지 만들어야함
	}	
	
	@GetMapping("/service_center/delete/{id}")
	public String fetchServicedelete(@PathVariable int id, Model model,
			@PageableDefault(size = 6, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		
		serviceCenter.deleteServiceById(id);
		Page<ServiceCenterEntity> service = serviceCenter.getServiceList(pageable);
		
		model.addAttribute("services", service);
		return "service_center/service_center";
	}

}
