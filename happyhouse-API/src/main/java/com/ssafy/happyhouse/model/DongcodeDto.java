package com.ssafy.happyhouse.model;

public class DongcodeDto {
	private String guCode;
	private String dongCode;
	private String gugunName;
	private String dongName;

	public DongcodeDto(String guCode, String gugunName) {
		this.guCode = guCode;
		this.gugunName = gugunName;
	}

	public DongcodeDto(String dongCode, String gugunName, String dongName) {
		this.dongCode = dongCode;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}

	public String getGuCode() {
		return guCode;
	}

	public String getDongCode() {
		return dongCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public String getDongName() {
		return dongName;
	}
}
