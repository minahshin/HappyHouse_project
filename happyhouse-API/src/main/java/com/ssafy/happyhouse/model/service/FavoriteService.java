package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.FavoriteDto;



@Service
public interface FavoriteService {
	FavoriteDto viewFavorite(String aptName) throws Exception;
	List<FavoriteDto> showFavoriteList(String memberId) throws Exception;
	void registerFavorite(FavoriteDto favoriteDto) throws Exception;
	void deleteFavorite(String memberId,String aptCode) throws Exception;
}
