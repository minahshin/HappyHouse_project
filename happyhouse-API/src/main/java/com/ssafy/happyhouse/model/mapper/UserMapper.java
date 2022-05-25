package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.NoticeDto;

@Mapper
public interface UserMapper {
	
	
	List<MemberDto> viewMemberList() throws Exception;
	MemberDto searchPw(MemberDto memberDto) throws Exception;
	int idCheck(String memberId) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	MemberDto login(MemberDto memberDto) throws Exception;
	MemberDto showInfo(String memberId) throws Exception;
	void updateMember(MemberDto memberDto) throws Exception;
	void deleteMember(String memberId) throws Exception;

	
}
