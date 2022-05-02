package com.ssafy.happyhouse.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.model.MemberDto;

@Mapper
public interface UserMapper {
	MemberDto logins(Map<String,String> map) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	MemberDto getMember(String userId) throws Exception;
	void updateUser(MemberDto memberDto) throws Exception;
	void deleteUser(String userId) throws Exception;

}
