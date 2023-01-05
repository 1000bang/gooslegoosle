package com.threebee.gooslegoosle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
	private PartnerService partnerService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/auth/partner/main_partner")
	public String fetchPartner() {
		return "partner/main_partner";
	}

	@GetMapping("/partner/application_partner")
	public String fetchApplicationPartnerForm() {
		return "partner/application_partner";
	}
	
	@PostMapping("/partner/{id}")
	public String fetchSavePartner( PartnerFileDTO partner,
			@PathVariable int id){
		    System.out.println(partner);
		    UserEntity user = userService.findId(id);
		
		partnerService.savePartner(partner, user);
		 
		return "partner/main_partner";	
	}
	
	
	@GetMapping("/partner/addstore/{id}")
	public String fetchAddStore(@PathVariable int id, Model model) {
		
		//TODO partner null 수정
		PartnerEntity partner = partnerService.findStoreByUserId(id);
		model.addAttribute("partner", partner);
		return "partner/add_store";
	}
	
	@PostMapping("/partner/add_store/{id}")
	public String fetchSaveStore(StoreFileDTO store, @PathVariable int id, Model model){
		
		PartnerEntity partner = partnerService.findPartnerById(id);
		StoreEntity stores = storeService.saveStore(store, partner);
		List<MenuEntity> menus = partnerService.findMenuByStoreId(stores.getId());
		model.addAttribute("menus", menus);
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
		partnerService.setUpload(id);
		System.out.println(menu);
		if(menu.getMenuName() == null || menu.getMenuName().equals("")) {
		}else {
		partnerService.saveMenu(menu, store);
		}
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
/* 필요없는 부분같음 나중에 지울 예정  
//	@GetMapping("/partner/add_partner/{id}")
//	@ResponseBody
//	public String fetchAddPartner(@PathVariable int id, Model model) {
//		PartnerEntity store = partnerService.findStoreByUserId(id);
//		model.addAttribute("store", store);
//
//		return "10";
//	}

//	@GetMapping("/partner/addMenu/{id}")
//	@ResponseBody
//	public ResponseDto<Integer> fetchAddMenu(@PathVariable int id, Model model) {
//		StoreEntity store = storeService.findStoreByStoreId(id);
//		List<MenuEntity> menus = partnerService.findMenuByStoreId(id);
//		
//		model.addAttribute("store", store);
//		model.addAttribute("menus", menus);
//		return new ResponseDto<Integer>(HttpStatus.OK, 1);
//	}
//	
*/	
	
	
	// 가게수정시 사할 예정  
	@DeleteMapping("/menu/delete/{id}")
	@ResponseBody
	public ResponseDto<Integer> fetchDeleteMenu(@PathVariable int id) {
		partnerService.deleteMenu(id);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}


}
