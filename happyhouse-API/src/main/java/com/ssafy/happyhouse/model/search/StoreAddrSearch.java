package com.ssafy.happyhouse.model.search;

import java.util.Arrays;
import java.util.List;

public class StoreAddrSearch {
	private String dongCode;
	private String keyword;
	private String categoryStr;
	private List<String> categories;
	private boolean isKidsSafe;
	
	public StoreAddrSearch(String dongCode, String keyword, String categoryStr, boolean isKidsSafe) {
		this.dongCode = dongCode;
		this.keyword = keyword;
		this.categoryStr = categoryStr;
		this.isKidsSafe = isKidsSafe;
		
		if(categories != null) {
			this.categories = Arrays.asList(categoryStr.split(","));
		}
	}
	public String getDongCode() {
		return dongCode;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public String getCategoryStr() {
		return categoryStr;
	}
	
	public List<String> getCategories() {
		return categories;
	}
	
	public boolean isKidsSafe() {
		return isKidsSafe;
	}
	
	public void setCategories() {
		this.categories = Arrays.asList(new String[] { "음식", "소매", "생활서비스", "부동산", "스포츠", "숙박", "학문/교육", "관광/여가/오락" });
	}
	
	@Override
	public String toString() {
		return "StoreAddrSearch [dongCode=" + dongCode + ", keyword=" + keyword + ", categoryStr=" + categoryStr
				+ ", categories=" + categories + ", isKidsSafe=" + isKidsSafe + "]";
	}
}
