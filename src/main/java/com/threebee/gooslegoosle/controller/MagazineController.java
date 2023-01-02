package com.threebee.gooslegoosle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.threebee.gooslegoosle.entity.MagazineEntity;
import com.threebee.gooslegoosle.service.MagazineService;

@Controller
public class MagazineController {

	@Autowired
	private MagazineService magazineService;
	
	@GetMapping("/magazine")
	public String fetchHome(Model model) {
		List<MagazineEntity> magazine = magazineService.findAllMagazine();
		model.addAttribute("magazine", magazine);
		return "/magazine/magazine_list";
	}

	@GetMapping("/magazine/board")
	public String fetchWrite() {
		
		return "/magazine/magazine_save";
	}

	@GetMapping("/magazine/detail/{id}")
	public String fetchDetail(Model model, @PathVariable int id) {
		model.addAttribute("magazine", magazineService.findMagazineById(id));
		
		return "/magazine/magazine_detail";
	}
	
	@GetMapping("/magazine/update/{id}")
	public String fetchUpdate(Model model, @PathVariable int id) {
		model.addAttribute("magazine", magazineService.findMagazineById(id));
		
		return "/magazine/magazine_update";
	}
}
