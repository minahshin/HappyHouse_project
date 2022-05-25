package com.ssafy.happyhouse.model;

public class AptScore {
	private int aptCode;
	private String aptName;
	private double average;

	public AptScore(int aptCode, String aptName, double average) {
		this.aptCode = aptCode;
		this.aptName = aptName;
		this.average = average;
	}

	public int getAptCode() {
		return aptCode;
	}

	public String getAptName() {
		return aptName;
	}

	public double getAverage() {
		return average;
	}
}
