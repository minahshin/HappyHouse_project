package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.FavoriteDto;
import com.ssafy.happyhouse.model.mapper.FavoriteMapper;

@Repository
public class FavoriteServiceDao implements FavoriteService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	private FavoriteMapper favoriteMapper;

	@Override
	public List<FavoriteDto> showFavoriteList(String memberId) throws Exception {
		
		return favoriteMapper.showFavoriteList(memberId);
	}

	@Override
	public void registerFavorite(FavoriteDto favoriteDto) throws Exception {
		
		favoriteMapper.registerFavorite(favoriteDto);
	}

	@Override
	public void deleteFavorite(String memberId,String aptCode) throws Exception {
		
		favoriteMapper.deleteFavorite(memberId,aptCode);
	}

	@Override
	public FavoriteDto viewFavorite(String aptName) throws Exception {
		
		return favoriteMapper.viewFavorite(aptName);
	}

}
