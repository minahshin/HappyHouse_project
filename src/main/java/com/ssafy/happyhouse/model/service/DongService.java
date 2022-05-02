package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.DongcodeDto;

@Service
public interface DongService {
	List<DongcodeDto> getDongInfo() throws Exception; 
}
