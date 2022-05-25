package com.ssafy.happyhouse.model.search;

public class AptSearch {
	private String guCode;
	private String dongCode;
	private String keyword;
	
	public AptSearch(String guCode, String dongCode, String keyword) {
		this.guCode = guCode;
		this.dongCode = dongCode;
		this.keyword = keyword;
	}

	public String getGuCode() {
		return guCode;
	}

	public String getDongCode() {
		return dongCode;
	}

	public String getKeyword() {
		return keyword;
	}
	
	public void setGuCode(String guCode) {
		this.guCode = guCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "AptSearch [guCode=" + guCode + ", dongCode=" + dongCode + ", keyword=" + keyword + "]";
	}
}
