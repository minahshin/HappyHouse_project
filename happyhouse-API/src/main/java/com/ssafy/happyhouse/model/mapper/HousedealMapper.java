package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.AptDto;
import com.ssafy.happyhouse.model.search.AptSearch;

@Mapper
public interface HousedealMapper {
	
	List<AptDto> searchByAptName(String aptName) throws Exception;
	List<AptDto> searchByDong(String dongName) throws Exception;
	List<AptDto> listApt() throws Exception;
	List<AptDto> getConditionedApt(AptSearch search) throws Exception;
}
