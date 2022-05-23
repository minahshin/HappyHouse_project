package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.mapper.AnswerMapper;

@Repository
public class AnswerServiceDao implements AnswerService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<AnswerDto> viewAllAnswers(String qno) {
		return answerMapper.viewAllAnswers(qno);
	}
	
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
