package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.AnswerDto;

@Service
public interface AnswerService {
	List<AnswerDto> viewAllAnswers(String qno);
	void registerAnswer(AnswerDto answerDto) throws Exception;
	void deleteAnswer(int ano) throws Exception;
	void updateAnswer(AnswerDto answerDto) throws Exception;

}
