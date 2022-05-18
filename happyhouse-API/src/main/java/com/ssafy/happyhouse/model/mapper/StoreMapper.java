package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.StoreDtoDistance;
import com.ssafy.happyhouse.model.search.StoreSearch;

@Mapper
public interface StoreMapper {
	public List<StoreDtoDistance> getAroundShop(StoreSearch searchKey) throws Exception;
}
