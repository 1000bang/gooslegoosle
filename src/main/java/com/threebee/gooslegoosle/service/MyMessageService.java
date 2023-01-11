package com.threebee.gooslegoosle.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.MessageEntity;
import com.threebee.gooslegoosle.repository.IMyMessageRepository;


@Service
public class MyMessageService {

	@Autowired
	IMyMessageRepository iMyMessageRepository;
	
	@Transactional
	public Page<MessageEntity> getMessageList( Pageable pageable) {
		
		return iMyMessageRepository.findAll(pageable);
	}
	
	@Transactional
	public MessageEntity getMessageDetail(int id) {
		return iMyMessageRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
	}

}
