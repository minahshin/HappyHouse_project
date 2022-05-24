package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.AnswerDto;

@Mapper
public interface AnswerMapper {
	List<AnswerDto> viewAllAnswers(String qno);
	void registerAnswer(AnswerDto answerDto) throws Exception;
	void deleteAnswer(int ano) throws Exception;
	void updateAnswer(AnswerDto answerDto) throws Exception;
	
}
