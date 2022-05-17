package com.ssafy.happyhouse.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.QuestionDto;
import com.ssafy.happyhouse.model.mapper.QuestionMapper;

@Repository
public class QuestionServiceDao implements QuestionService{
	
	@Autowired
	SqlSession sqlSession;
	
	private QuestionMapper questionMapper;

	@Override
	public void registerQuestion(QuestionDto questionDto) throws Exception {
		
		questionMapper.registerQuestion(questionDto);
	}

	@Override
	public void updateQuestion(QuestionDto questionDto) throws Exception {
		
		questionMapper.updateQuestion(questionDto);
	}

	@Override
	public void deleteQuestion(String memberId, String qno) throws Exception {
		
		questionMapper.deleteQuestion(memberId, qno);
	}

}
