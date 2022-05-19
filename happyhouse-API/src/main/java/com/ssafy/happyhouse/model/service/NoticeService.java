package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.NoticeDto;


@Service
public interface NoticeService {
	List<NoticeDto> viewNoticeList() throws Exception;
	NoticeDto viewNotice(String nno) throws Exception;
	void registerNotice(NoticeDto noticeDto) throws Exception;
	void updateNotice(NoticeDto noticeDto) throws Exception;
	void deleteNotice(int nno) throws Exception;
}
