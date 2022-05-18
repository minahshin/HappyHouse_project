package com.ssafy.happyhouse.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.mapper.AnswerMapper;

@Repository
public class AnswerServiceDao implements AnswerService{
	
	@Autowired
	SqlSession sqlSession;
	
	private AnswerMapper answerMapper;

	@Override
	public void updateAnswer(AnswerDto answerDto) throws Exception {
		answerMapper.updateAnswer(answerDto);
	}

	@Override
	public void deleteAnswer(int ano) throws Exception{
		
		answerMapper.deleteAnswer(ano);
	}

	@Override
	public void registerAnswer(AnswerDto answerDto) throws Exception {
		answerMapper.registerAnswer(answerDto);
		
	}


}
