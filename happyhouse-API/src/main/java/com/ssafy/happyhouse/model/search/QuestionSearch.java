package com.ssafy.happyhouse.model.search;

import java.util.List;

public class QuestionSearch {
	private String userid;
	private List<String> categories;
	private String keyword;
	private String writer;
	
	public QuestionSearch(String userid, List<String> categories, String keyword, String writer) {
		this.userid = userid;
		this.categories = categories;
		this.keyword = keyword;
		this.writer = writer;
	}

	public String getUserid() {
		return userid;
	}

	public List<String> getCategories() {
		return categories;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getWriter() {
		return writer;
	}

	@Override
	public String toString() {
		return "QuestionSearch [userid=" + userid + ", categories=" + categories + ", keyword=" + keyword + ", writer="
				+ writer + "]";
	}
}
