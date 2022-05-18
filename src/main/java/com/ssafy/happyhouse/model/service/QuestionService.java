package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.QuestionDto;
import com.ssafy.happyhouse.model.search.QuestionSearch;

@Service
public interface QuestionService {
	List<QuestionDto> viewQuestionList(QuestionSearch search) throws Exception;
	QuestionDto viewQuestion(String qno, String userid) throws Exception;
	void registerQuestion(QuestionDto questionDto) throws Exception;
	void updateQuestion(QuestionDto questionDto) throws Exception;
	void deleteQuestion(int qno) throws Exception;
	
	String getWriter(String qno) throws Exception;
}
