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
		if(favoriteService.checkFavorite(favoriteDto.getMemberId(), String.valueOf(favoriteDto.getAptCode())) == 1) {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		favoriteService.registerFavorite(favoriteDto);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteFavorite( String memberId, String aptCode ) throws Exception {
		
		if(favoriteService.checkFavorite(memberId, aptCode) == 0) {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		favoriteService.deleteFavorite(memberId,aptCode);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping("/check")
	public ResponseEntity<Boolean> checkFavoriteRegistered(String memberId, String aptCode) throws Exception {
		int checkCount = favoriteService.checkFavorite(memberId, aptCode);
		
		// 등록 안되어있을 시 false, 되어있을 시 true
		return new ResponseEntity<Boolean>(checkCount == 0 ? false : true, HttpStatus.OK);
	}

}
