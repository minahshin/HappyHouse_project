package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.model.NoticeDto;


@Mapper
public interface NoticeMapper {
	List<NoticeDto> viewNoticeList() throws Exception;
	NoticeDto viewNotice(String nno) throws Exception;
	void registerNotice(NoticeDto noticeDto) throws Exception;
	void updateNotice(NoticeDto noticeDto) throws Exception;
	void deleteNotice(int nno) throws Exception;
	
}
