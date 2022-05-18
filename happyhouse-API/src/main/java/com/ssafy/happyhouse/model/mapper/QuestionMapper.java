package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.QuestionDto;
import com.ssafy.happyhouse.model.search.QuestionSearch;

@Mapper
public interface QuestionMapper {
	List<QuestionDto> viewQuestionList(QuestionSearch search) throws Exception;
	QuestionDto viewQuestion(@Param("qno") String qno, @Param("userid") String userid) throws Exception;
	void registerQuestion(QuestionDto questionDto) throws Exception;
	void updateQuestion(QuestionDto questionDto) throws Exception;
	void deleteQuestion(int qno) throws Exception;
	
	String getWriter(String qno) throws Exception;
}
