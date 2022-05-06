package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.StoreDtoDistance;
import com.ssafy.happyhouse.model.StoreSearch;
import com.ssafy.happyhouse.model.mapper.StoreMapper;

@Repository
public class StoreServiceDao implements StoreService{

	@Autowired
	private StoreMapper mapper;
	
	@Override
	public List<StoreDtoDistance> getAroundShop(StoreSearch searchKey) throws Exception {

		return mapper.getAroundShop(searchKey);
	}

}
