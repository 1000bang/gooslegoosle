package com.threebee.gooslegoosle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threebee.gooslegoosle.entity.MessageEntity;

public interface IMessageRepository extends JpaRepository<MessageEntity, Integer>{


}
