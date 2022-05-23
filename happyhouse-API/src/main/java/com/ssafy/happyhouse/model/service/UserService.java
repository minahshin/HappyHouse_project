package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.MemberDto;

public interface UserService {
	
	
	MemberDto searchPw(MemberDto memberDto) throws Exception;
	int idCheck(String memberId) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	MemberDto login(MemberDto memberDto) throws Exception;
	MemberDto showInfo(String memberId) throws Exception;
	void updateMember(MemberDto memberDto) throws Exception;
	void deleteMember(String memberId) throws Exception;

}
