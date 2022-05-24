package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.AptDto;
import com.ssafy.happyhouse.model.mapper.HousedealMapper;
import com.ssafy.happyhouse.model.search.AptSearch;

@Repository
public class HousedealServiceDao implements HousedealService{
	@Autowired
	private HousedealMapper housedealMapper;

	@Override
	public List<AptDto> searchByAptName(String aptName) throws Exception {
		
		return housedealMapper.searchByAptName(aptName);
	}

	@Override
	public List<AptDto> searchByDong(String dongName) throws Exception {
		
		return housedealMapper.searchByDong(dongName);
	}

	@Override
	public List<AptDto> listApt() throws Exception {
		
		return housedealMapper.listApt();
	}

	@Override
	public List<AptDto> getConditionedApt(AptSearch search) throws Exception {
		return housedealMapper.getConditionedApt(search);
	}

}
