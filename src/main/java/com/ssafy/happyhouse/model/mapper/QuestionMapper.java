package com.ssafy.happyhouse.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.QuestionDto;

@Mapper
public interface QuestionMapper {
	void registerQuestion(QuestionDto questionDto) throws Exception;
	void updateQuestion(QuestionDto questionDto) throws Exception;
	void deleteQuestion(String memberId,String qno) throws Exception;

}
