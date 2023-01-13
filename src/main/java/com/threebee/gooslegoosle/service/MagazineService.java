package com.threebee.gooslegoosle.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.dto.MagazineFileDTO;
import com.threebee.gooslegoosle.entity.MagazineEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IMagazineRepository;

@Service
public class MagazineService {

	@Autowired
	IMagazineRepository magazineRepository;
	
	@Value("${file.path}")
	private String uploadFolder;
	
	public void writeMagazine(MagazineFileDTO file, UserEntity user) {
		UUID uuid = UUID.randomUUID();
		
		String filename = uuid + "_"+file.getFile().getOriginalFilename(); 
		
		Path imageFilePath = Paths.get(uploadFolder + filename );
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

	public  Page<MagazineEntity> findAllMagazine(Pageable pageable) {
		 Page<MagazineEntity> magazines = magazineRepository.findAll(pageable);
		return magazines;
	}

	public void deleteMagazine(int id) {
		magazineRepository.deleteById(id);
	}
	
}
