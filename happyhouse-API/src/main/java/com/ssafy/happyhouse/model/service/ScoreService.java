package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.AptScore;
import com.ssafy.happyhouse.model.ScoreDto;

@Service
public interface ScoreService {
	AptScore getAptScore(String aptCode) throws Exception;
	Integer checkScored(ScoreDto score) throws Exception;
	List<AptScore> getBestScored() throws Exception;
	List<ScoreDto> showScores(String memberId) throws Exception;
	
	void addScore(ScoreDto score) throws Exception;
	void updateScore(ScoreDto score) throws Exception;
	void deleteScore(ScoreDto score) throws Exception;
}
