package com.ssafy.happyhouse.model;

public class FavoriteDto {

	private String aptName;
	private String memberId;
	private int aptCode;
	private String lat;
	private String lng;
	
	
	


	public String getAptName() {
		return aptName;
	}



	public void setAptName(String aptName) {
		this.aptName = aptName;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public int getAptCode() {
		return aptCode;
	}





	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}





	@Override
	public String toString() {
		return "FavoriteDto [memberId=" + memberId + ", aptCode=" + aptCode + "]";
	}
	
	
	
	

}
