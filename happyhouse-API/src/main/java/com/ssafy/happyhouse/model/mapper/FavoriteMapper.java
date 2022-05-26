package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.FavoriteDto;


@Mapper
public interface FavoriteMapper {
	FavoriteDto viewFavorite(String aptName) throws Exception;
	List<FavoriteDto> showFavoriteList(String memberId) throws Exception;
	int checkFavorite(@Param("memberId") String memberId,@Param("aptCode") String aptCode) throws Exception;
	void registerFavorite(FavoriteDto favoriteDto) throws Exception;
	void deleteFavorite(@Param("memberId") String memberId,@Param("aptCode") String aptCode) throws Exception;
}
