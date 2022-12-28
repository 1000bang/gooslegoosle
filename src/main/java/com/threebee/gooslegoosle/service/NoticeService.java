package com.threebee.gooslegoosle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.gooslegoosle.entity.NoticeEntity;
import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.INoticeRepository;



@Service
public class NoticeService {

	@Autowired
	INoticeRepository noticeRepository;
	
	public void writeNotice(NoticeEntity notice, UserEntity user) {
		// 가독성을 위해 한번더 지정
		notice.setCount(0);
		notice.setUserId(user);
		noticeRepository.save(notice);
	}
	
	@Transactional(readOnly = true)
	public Page<NoticeEntity> getNoticeList(Pageable pagalbe) {

		return noticeRepository.findAll(pagalbe);
	}
	
	@Transactional
	public NoticeEntity getNoticeDetail(int id) {
		return noticeRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
	}
	
	
}
