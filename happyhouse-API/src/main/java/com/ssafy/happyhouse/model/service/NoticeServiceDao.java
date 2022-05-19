package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Repository
public class NoticeServiceDao implements NoticeService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public List<NoticeDto> viewNoticeList() throws Exception {
		
		return noticeMapper.viewNoticeList();
	}

	@Override
	public NoticeDto viewNotice(String nno) throws Exception {
		
		return noticeMapper.viewNotice(nno);
	}

	@Override
	public void registerNotice(NoticeDto noticeDto) throws Exception {
		
		noticeMapper.registerNotice(noticeDto);
	}

	@Override
	public void updateNotice(NoticeDto noticeDto) throws Exception {
		
		noticeMapper.updateNotice(noticeDto);
	}

	@Override
	public void deleteNotice(int nno) throws Exception {
		
		noticeMapper.deleteNotice(nno);
		
	}

}
