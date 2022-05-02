package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.AptDto;

@Mapper
public interface HousedealMapper {
	
	List<AptDto> searchByAptName(String aptName) throws Exception;
	List<AptDto> searchByDong(String dongName) throws Exception;
	List<AptDto> listApt() throws Exception;
}
