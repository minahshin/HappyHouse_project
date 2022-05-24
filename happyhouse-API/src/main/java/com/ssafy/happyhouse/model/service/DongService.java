package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.DongcodeDto;

@Service
public interface DongService {
	List<DongcodeDto> getGuInfo() throws Exception; 
	List<DongcodeDto> getDongInfo(String guCode) throws Exception; 
}
