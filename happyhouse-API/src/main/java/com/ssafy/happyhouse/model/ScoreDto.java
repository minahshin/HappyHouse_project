package com.ssafy.happyhouse.model;

public class ScoreDto {
	private String memberId;
	private int aptCode;
	private String aptName;
	private int score;
	
	public ScoreDto() {}
	
	public ScoreDto(String memberId, int aptCode) {
		this.memberId = memberId;
		this.aptCode = aptCode;
	}
	
	public ScoreDto(String memberId, int aptCode, String aptName, int score) {
		this.memberId = memberId;
		this.aptCode = aptCode;
		this.aptName = aptName;
		this.score = score;
	}

	public String getMemberId() {
		return memberId;
	}

	public int getAptCode() {
		return aptCode;
	}

	public String getAptName() {
		return aptName;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "ScoreDto [memberId=" + memberId + ", aptCode=" + aptCode + ", aptName=" + aptName + ", score=" + score
				+ "]";
	}
}
