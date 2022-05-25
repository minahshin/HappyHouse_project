package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.AptScore;
import com.ssafy.happyhouse.model.DongcodeDto;
import com.ssafy.happyhouse.model.ScoreDto;
import com.ssafy.happyhouse.model.mapper.DongMapper;
import com.ssafy.happyhouse.model.mapper.ScoreMapper;

@Repository
public class ScoreServiceDao implements ScoreService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	ScoreMapper scoreMapper;

	@Override
	public AptScore getAptScore(String aptCode) throws Exception {
		return scoreMapper.getAptScore(aptCode);
	}

	@Override
	public Integer checkScored(ScoreDto score) throws Exception {
		Integer userScore = scoreMapper.checkScored(score);
		return userScore == null ? 0 : userScore;
	}

	@Override
	public List<AptScore> getBestScored() throws Exception {
		return scoreMapper.getBestScored();
	}

	@Override
	public void addScore(ScoreDto score) throws Exception {
		scoreMapper.addScore(score);
		
	}

	@Override
	public void updateScore(ScoreDto score) throws Exception {
		scoreMapper.updateScore(score);
	}

	@Override
	public void deleteScore(ScoreDto score) throws Exception {
		scoreMapper.deleteScore(score);
	}

	@Override
	public List<ScoreDto> showScores(String memberId) throws Exception {
		return scoreMapper.showScores(memberId);
	}
}
