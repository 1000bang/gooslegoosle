package com.threebee.gooslegoosle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.entity.MessageEntity;
import com.threebee.gooslegoosle.repository.IMyMessageRepository;

@Service
public class MyMessageService {

	@Autowired
	IMyMessageRepository iMyMessageRepository;

	@Transactional
	public Page<MessageEntity> getMessageList(int id, Pageable pageable) {
		
		return iMyMessageRepository.findMyMessage(id, pageable);
	}
	
	@Transactional
	public Page<MessageEntity> getAllMessageList(Pageable pageable) {
		
		return iMyMessageRepository.findAll(pageable);
	}

	@Transactional
	public MessageEntity getMessageDetail(int id, PrincipalDetail detail) {

		MessageEntity msg = iMyMessageRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 메세지를 찾을 수 없습니다.");
		});
		 
		msg.setRead(true);

		List<MessageEntity> mes = iMyMessageRepository.findAllById(detail.getUser().getId());

		detail.getUser().setMessage(mes);
		
		return msg;
	}

}
