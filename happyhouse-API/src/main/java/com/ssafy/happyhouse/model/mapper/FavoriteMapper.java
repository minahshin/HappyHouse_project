package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.FavoriteDto;


@Mapper
public interface FavoriteMapper {
	FavoriteDto viewFavorite(String aptName) throws Exception;
	List<FavoriteDto> showFavoriteList(String memberId) throws Exception;
	void registerFavorite(FavoriteDto favoriteDto) throws Exception;
	void deleteFavorite(FavoriteDto favoriteDto) throws Exception;
}
