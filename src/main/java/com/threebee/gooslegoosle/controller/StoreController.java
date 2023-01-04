package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.dto.StoreFileDTO;
import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.ReservationEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.ReservationService;
import com.threebee.gooslegoosle.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	private	StoreService storeService;
	
	@Autowired
	private PartnerService partnerService;
	
	@GetMapping("/store/{id}")
	public String fetchIndex(Model model, @PathVariable int id) {
		
		StoreEntity detail = storeService.findStoreDetailByStoreId(id);
		
		model.addAttribute("storeDetail",detail);
		return "/store/detail";
	}
	
	@PostMapping("/partner/add_store/{id}")
	public String saveStore(StoreFileDTO store, @PathVariable int id, Model model){
		
		System.out.println("store>>>>>>" +store);
		PartnerEntity partner = partnerService.findPartnerById(id);
		System.out.println("partner>>>>>"+partner);
		StoreEntity stores = storeService.saveStore(store, partner);
		model.addAttribute("store", stores);
		return "partner/add_menu";	
	}
	
	@GetMapping("/store/reservation/{id}")
	public String fetchReserve(Model model, @PathVariable int id) {
		
		StoreEntity detail = storeService.findStoreDetailByStoreId(id);
		
		model.addAttribute("storeDetail",detail);
		return "/store/reservation";
	}
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/store/reservation/{id}/save")
	@ResponseBody
	public ResponseDto<Integer> fetchSaveReserve(@RequestBody ReservationEntity res, @PathVariable int id, @AuthenticationPrincipal PrincipalDetail detail) {
		StoreEntity store = storeService.findStoreDetailByStoreId(id);
		reservationService.saveReservation(res, store, detail.getUser());
		
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}

	
}
