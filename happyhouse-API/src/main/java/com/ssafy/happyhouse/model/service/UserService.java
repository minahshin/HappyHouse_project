package com.ssafy.happyhouse.model.service;

import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;

public interface UserService {
	
	MemberDto searchPw(Map<String,String> map) throws Exception;
	int idCheck(String memberId) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	MemberDto login(Map<String,String> map) throws Exception;
	void updateMember(MemberDto memberDto) throws Exception;
	void deleteMember(String memberId) throws Exception;

}
