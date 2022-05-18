package com.ssafy.happyhouse.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.QuestionDto;

@Mapper
public interface AnswerMapper {
	
	void registerAnswer(AnswerDto answerDto) throws Exception;
	void deleteAnswer(int ano) throws Exception;
	void updateAnswer(AnswerDto answerDto) throws Exception;
	
}
