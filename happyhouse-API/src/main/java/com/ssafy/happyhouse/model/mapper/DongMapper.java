package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.DongcodeDto;

@Mapper
public interface DongMapper {
	List<DongcodeDto> getGuInfo() throws Exception; 
	List<DongcodeDto> getDongInfo(String guCode) throws Exception; 
}
