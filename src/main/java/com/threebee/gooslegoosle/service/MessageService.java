package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.MessageEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IMessageRepository;
import com.threebee.gooslegoosle.repository.IUserRepository;

@Service
public class MessageService {

	@Autowired
	IMessageRepository messageRepository;

	@Autowired
	IUserRepository userRepository;

	public void sendMessage(int id, MessageEntity mes) {

		UserEntity user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다.");
		});
		mes.setUser(user);
		mes.setRead(false);
		messageRepository.save(mes);

	}

}
