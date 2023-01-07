package com.threebee.gooslegoosle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.MagazineFileDTO;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.entity.MagazineEntity;
import com.threebee.gooslegoosle.service.MagazineService;

@Controller
public class MagazineController {

	@Autowired
	private MagazineService magazineService;

	@GetMapping("/magazine")
	public String fetchHome(Model model,
			@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {
		Page<MagazineEntity> magazine = magazineService.findAllMagazine(pageable);
		int nowPage = magazine.getPageable().getPageNumber() + 1;
		int startPageNumber = Math.max(nowPage - 2, 1);
		int endPageNumber = Math.min(nowPage + 2, magazine.getTotalPages());
		int end = magazine.getTotalPages() - 1;

		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			pageNumbers.add(i);
		}
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", 0);
		model.addAttribute("endPage", end);
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
	public String fetchSave(MagazineFileDTO file, Model model, @AuthenticationPrincipal PrincipalDetail detail) {

		magazineService.writeMagazine(file, detail.getUser());

		return "redirect:/magazine";
	}

	@GetMapping("/api/magazine/delete/{id}")
	public String delete(@PathVariable int id, Model model) {

		magazineService.deleteMagazine(id);


		return "redirect:/magazine";
	}

}
