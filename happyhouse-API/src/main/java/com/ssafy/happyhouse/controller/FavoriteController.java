package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.FavoriteDto;
import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.FavoriteService;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	

	@GetMapping("/list/{memberId}")
	public ResponseEntity<?> showFavoriteList(@PathVariable String memberId) throws Exception{	
		return new ResponseEntity<List<FavoriteDto>>(favoriteService.showFavoriteList(memberId), HttpStatus.OK);	
	}
	
	@GetMapping("/{aptName}")
	public ResponseEntity<?> viewFavorite(@PathVariable String aptName) throws Exception{
		
		return new ResponseEntity<FavoriteDto>(favoriteService.viewFavorite(aptName), HttpStatus.OK);	
	}
	
	@PostMapping("/regist")
	public ResponseEntity<String> registerFavorite(@RequestBody FavoriteDto favoriteDto) throws Exception {
		favoriteService.registerFavorite(favoriteDto);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{favoriteDto}")
	public ResponseEntity<String> deleteFavorite(@PathVariable FavoriteDto favoriteDto ) throws Exception {
		
		
		favoriteService.deleteFavorite(favoriteDto);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	

	

}
