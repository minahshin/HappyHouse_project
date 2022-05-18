package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.DongcodeDto;
import com.ssafy.happyhouse.model.mapper.DongMapper;

@Repository
public class DongServiceDao implements DongService{
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public List<DongcodeDto> getDongInfo() throws Exception {
		DongMapper mapper = sqlSession.getMapper(DongMapper.class);
		return mapper.getDongInfo();
	}

}
