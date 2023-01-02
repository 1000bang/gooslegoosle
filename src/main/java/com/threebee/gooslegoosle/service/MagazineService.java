package com.threebee.gooslegoosle.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.dto.FileDTO;
import com.threebee.gooslegoosle.entity.MagazineEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IMagazineRepository;

@Service
public class MagazineService {

	@Autowired
	IMagazineRepository magazineRepository;
	
	
	public void writeMagazine(FileDTO file, UserEntity user) {
		UUID uuid = UUID.randomUUID();
		
		String filename = uuid + "_"+file.getFile().getOriginalFilename(); 
		
		Path imageFilePath = Paths.get("/Users/1000bang/workspace/soulfood/gooslegoosle/src/main/resources/static/images" + filename );
		try {
			Files.write(imageFilePath, file.getFile().getBytes());
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MagazineEntity magazine = file.toEntity(filename, user);
		
		magazine.setCount(0);
		magazineRepository.save(magazine);
	}

	public MagazineEntity findMagazineById(int id) {
		return magazineRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다. ");
		});
		
	}
	
	@Transactional
	public int modifyMagazine(int id, MagazineEntity magazine) {
		MagazineEntity magazines = findMagazineById(id);
		magazines.setTitle(magazine.getTitle());
		magazines.setContent(magazine.getContent());
		return 1;
	}

	public  List<MagazineEntity> findAllMagazine() {
		 List<MagazineEntity> magazines = magazineRepository.findAll();
		return magazines;
	}
	
}
