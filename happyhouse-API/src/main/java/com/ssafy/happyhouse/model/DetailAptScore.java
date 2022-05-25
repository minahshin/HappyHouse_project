package com.ssafy.happyhouse.model;

public class DetailAptScore {
	private double aptScore;
	private int userScore;
	
	public DetailAptScore() {}
	
	public DetailAptScore(double aptScore, int userScore) {
		this.aptScore = aptScore;
		this.userScore = userScore;
	}
	
	public double getAptScore() {
		return aptScore;
	}
	public int getUserScore() {
		return userScore;
	}

	public void setAptScore(double aptScore) {
		this.aptScore = aptScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	@Override
	public String toString() {
		return "DetailAptScore [aptScore=" + aptScore + ", userScore=" + userScore + "]";
	}
	
}
