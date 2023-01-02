package com.threebee.gooslegoosle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.FileDTO;
import com.threebee.gooslegoosle.dto.ResponseDto;
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
	


	@PostMapping("/magazine/save")
	public String fetchSave(FileDTO file, 
			@AuthenticationPrincipal PrincipalDetail detail) {
		System.out.println(detail);
		System.out.println("file >>>>>>>"+ file.getFile().getOriginalFilename());
		magazineService.writeMagazine(file, detail.getUser());
		return "/magazine/magazine_list";
	}
	
	@GetMapping("/api/magazine/delete/{id}")
	public String delete(@PathVariable int id){
		magazineService.deleteMagazine(id);
		return "/magazine/magazine_list";
	}
	
}
