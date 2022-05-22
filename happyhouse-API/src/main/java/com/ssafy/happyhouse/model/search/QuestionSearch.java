package com.ssafy.happyhouse.model.search;

import java.util.Arrays;
import java.util.List;

public class QuestionSearch {
	private String userid;
	private String categories;
	private List<String> categoryList;
	private String keyword;
	private String writer;
	
	public QuestionSearch(String userid, String categories, String keyword, String writer) {
		this.userid = userid;
		this.categories = categories;
		this.keyword = keyword;
		this.writer = writer;
		
		if(categories != null) {
			this.categoryList = Arrays.asList(categories.split(","));
		}
	}

	public String getUserid() {
		return userid;
	}

	public String getCategories() {
		return categories;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getWriter() {
		return writer;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "QuestionSearch [userid=" + userid + ", categories=" + categories + ", keyword=" + keyword + ", writer="
				+ writer + "]";
	}
}
