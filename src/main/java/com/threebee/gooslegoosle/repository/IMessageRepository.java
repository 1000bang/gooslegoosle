package com.threebee.gooslegoosle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.threebee.gooslegoosle.entity.MessageEntity;

public interface IMessageRepository extends JpaRepository<MessageEntity, Integer>{



}
