package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.StoreDtoDistance;
import com.ssafy.happyhouse.model.search.StoreSearch;

@Service
public interface StoreService {
	public List<StoreDtoDistance> getAroundShop(StoreSearch searchKey) throws Exception;
}
