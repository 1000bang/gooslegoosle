package com.threebee.gooslegoosle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threebee.gooslegoosle.dto.PartnerFileDTO;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.dto.StoreFileDTO;
import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.StoreService;
import com.threebee.gooslegoosle.service.UserService;

@Controller
public class PartnerController {

	@Autowired
	PartnerService partnerService;
	
	@Autowired
	StoreService storeService;

	@GetMapping("/auth/partner/main_partner")
	public String fetchPartner() {
		return "partner/main_partner";
	}

	@GetMapping("/partner/application_partner")
	public String fetchApplicationPartnerForm() {
		return "partner/application_partner";
	}

	@GetMapping("/partner/addstore/{id}")
	public String fetchAddStore(@PathVariable int id, Model model) {
		
		//TODO partner null 수정
		PartnerEntity partner = partnerService.findStoreByUserId(id);
		model.addAttribute("partner", partner);
		return "partner/add_store";
	}
	
	@PostMapping("/partner/add_store/{id}")
	public String saveStore(StoreFileDTO store, @PathVariable int id, Model model){
		
		PartnerEntity partner = partnerService.findPartnerById(id);
		StoreEntity stores = storeService.saveStore(store, partner);
		model.addAttribute("store", stores);
		return "partner/add_menu";	
	}
	
	
	@PostMapping("/partner/add_menu/{id}")
	@ResponseBody
	public ResponseDto<MenuEntity> fetchSaveMenu(@RequestBody MenuEntity menu, @PathVariable int id){
		StoreEntity store = storeService.findStoreByStoreId(id);
		MenuEntity menus = partnerService.saveMenu(menu, store);

		return new ResponseDto<MenuEntity>(HttpStatus.OK, menus);
	}
	
	@PostMapping("/partner/add_menu/{id}/done")
	@ResponseBody
	public ResponseDto<Integer> fetchSaveMenuDone(@RequestBody MenuEntity menu, @PathVariable int id){
		StoreEntity store = storeService.findStoreByStoreId(id);
		System.out.println(menu);
		if(menu.getMenuName() == null && menu.getMenuName().equals("")) {
		}else {
		partnerService.saveMenu(menu, store);
		}
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	
	@GetMapping("/partner/add_partner/{id}")
	@ResponseBody
	public String fetchAddPartner(@PathVariable int id, Model model) {

		PartnerEntity store = partnerService.findStoreByUserId(id);
		model.addAttribute("store", store);

		return "10";

	}

	@GetMapping("/partner/addMenu/{id}")
	public String fetchAddMenu(@PathVariable int id, Model model) {
		partnerService.setUpload(id);
		PartnerEntity partner = partnerService.findPartnerById(id);
		model.addAttribute("partner", partner);
		return "partner/add_menu";

	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/partner/{id}")
	public String savePartner( PartnerFileDTO partner,
			@PathVariable int id){
		    System.out.println(partner);
		    UserEntity user = userService.findId(id);
		
		partnerService.savePartner(partner, user);
		 
		return "partner/main_partner";
		
	}
	
	
	
	@DeleteMapping("/menu/delete/{id}")
	public String fetchDeleteMenu() {
		//1/5일 할거 
		return null;
	}


}
