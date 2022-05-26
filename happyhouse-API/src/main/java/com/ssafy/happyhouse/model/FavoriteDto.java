package com.ssafy.happyhouse.model;

public class FavoriteDto {

	private String aptName;
	private String memberId;
	private int aptCode;
	private String lat;
	private String lng;
	
	public FavoriteDto(String aptName, int aptCode, String lat, String lng) {
		this.aptName = aptName;
		this.aptCode = aptCode;
		this.lat = lat;
		this.lng = lng;
	}
	
	public String getAptName() {
		return aptName;
	}
	public String getMemberId() {
		return memberId;
	}

	public int getAptCode() {
		return aptCode;
	}

	public String getLat() {
		return lat;
	}

	public String getLng() {
		return lng;
	}

	@Override
	public String toString() {
		return "FavoriteDto [memberId=" + memberId + ", aptCode=" + aptCode + "]";
	}

}
