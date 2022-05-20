package com.ssafy.happyhouse.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Repository
public class UserServiceDao implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public MemberDto searchPw(Map<String, String> map) throws Exception {

		return userMapper.searchPw(map);
	}

	@Override
	public int idCheck(String memberId) throws Exception {
		
		return userMapper.idCheck(memberId);
	}

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
		
		userMapper.registerMember(memberDto);	
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		
		return userMapper.login(map);
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		userMapper.updateMember(memberDto);
	}

	@Override
	public void deleteMember(String memberId) throws Exception {
		userMapper.deleteMember(memberId);
	}

	@Override
	public MemberDto showInfo(String memberId) throws Exception {
		
		return userMapper.showInfo(memberId);
	}

}
