package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.handler.CommonUtilHandler;
import com.ssafy.happyhouse.model.AptScore;
import com.ssafy.happyhouse.model.DetailAptScore;
import com.ssafy.happyhouse.model.ScoreDto;
import com.ssafy.happyhouse.model.service.ScoreService;

@RestController
@RequestMapping("/score")
public class ScoreController {
	
	@Autowired
	ScoreService scoreService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 별점 조회(by apt)
	@GetMapping
	public ResponseEntity<DetailAptScore> getAptScoreStatus(String memberId, String aptCode) throws Exception{
		logger.debug("[aptCode] " + aptCode);
		
		DetailAptScore scoreInfo = new DetailAptScore(0, 0);
		
		AptScore result = scoreService.getAptScore(aptCode);
		
		if(result != null)
			scoreInfo.setAptScore(result.getAverage());
		
		if(!CommonUtilHandler.empty(memberId)) {
			scoreInfo.setUserScore(scoreService.checkScored(new ScoreDto(memberId, Integer.parseInt(aptCode))));
		}
		
		logger.debug(scoreInfo.toString());
		
		return new ResponseEntity<DetailAptScore>(scoreInfo, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ScoreDto>> getUserScore(String memberId) throws Exception {
		return new ResponseEntity<List<ScoreDto>>(scoreService.showScores(memberId), HttpStatus.OK);
	}
	
	// 별점 높은 순으로 조회(최대 5개)
	@GetMapping("/best")
	public ResponseEntity<?> getHighestAptScore() throws Exception{
		return new ResponseEntity<List<AptScore>>(scoreService.getBestScored(), HttpStatus.OK);
	}
	
	// 평가(by apt, memberId)
	@PostMapping("/add")
	public ResponseEntity<?> addAptScore(@RequestBody ScoreDto score) throws Exception{
		logger.debug(score.toString());
		
		if(scoreService.checkScored(score) == 0)
			scoreService.addScore(score);
		else
			scoreService.updateScore(score);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	// 별점 삭제(by apt, memberId)
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteAptScore(String memberId, String aptCode) throws Exception{
		
		ScoreDto score = new ScoreDto(memberId, Integer.parseInt(aptCode));
		
		scoreService.deleteScore(score);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
