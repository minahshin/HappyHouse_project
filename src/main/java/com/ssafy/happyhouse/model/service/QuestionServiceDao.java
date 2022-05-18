package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.QuestionDto;
import com.ssafy.happyhouse.model.mapper.QuestionMapper;
import com.ssafy.happyhouse.model.search.QuestionSearch;

@Repository
public class QuestionServiceDao implements QuestionService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	private QuestionMapper questionMapper;

	@Override
	public List<QuestionDto> viewQuestionList(QuestionSearch search) throws Exception {
		return questionMapper.viewQuestionList(search);
	}
	
	@Override
	public QuestionDto viewQuestion(String qno, String userid) throws Exception {
		return questionMapper.viewQuestion(qno, userid);
	}
	
	@Override
	public void registerQuestion(QuestionDto questionDto) throws Exception {
		
		questionMapper.registerQuestion(questionDto);
	}

	@Override
	public void updateQuestion(QuestionDto questionDto) throws Exception {
		
		questionMapper.updateQuestion(questionDto);
	}

	@Override
	public void deleteQuestion(int qno) throws Exception {
		
		questionMapper.deleteQuestion(qno);
	}

	@Override
	public String getWriter(String qno) throws Exception {
		return questionMapper.getWriter(qno);
	}
}
