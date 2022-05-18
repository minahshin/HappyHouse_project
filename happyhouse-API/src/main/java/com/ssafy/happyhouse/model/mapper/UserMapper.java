package com.ssafy.happyhouse.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.model.MemberDto;

@Mapper
public interface UserMapper {
	
	MemberDto searchPw(Map<String,String> map) throws Exception;
	int idCheck(String memberId) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	MemberDto login(Map<String,String> map) throws Exception;
	void updateMember(MemberDto memberDto) throws Exception;
	void deleteMember(String memberId) throws Exception;

}
