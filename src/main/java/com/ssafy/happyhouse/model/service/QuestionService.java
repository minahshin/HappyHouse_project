package com.ssafy.happyhouse.model.service;

import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.model.QuestionDto;

@Service
public interface QuestionService {
	void registerQuestion(QuestionDto questionDto) throws Exception;
	void updateQuestion(QuestionDto questionDto) throws Exception;
	void deleteQuestion(String memberId,String qno) throws Exception;
}
