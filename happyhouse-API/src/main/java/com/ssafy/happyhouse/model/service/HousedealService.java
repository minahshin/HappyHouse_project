package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.AptDto;
import com.ssafy.happyhouse.model.search.AptSearch;

public interface HousedealService {

	List<AptDto> searchByAptName(String aptName) throws Exception;
	List<AptDto> searchByDong(String dongName) throws Exception;
	List<AptDto> listApt() throws Exception;
	List<AptDto> getConditionedApt(AptSearch search) throws Exception;
}
