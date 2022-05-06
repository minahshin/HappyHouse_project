package com.ssafy.happyhouse.model;

import java.util.Arrays;
import java.util.List;

public class StoreSearch {
	private double lat;
	private double lng;
	private double distance;
	private String keyword;
	private List<String> categories;
	private List<String> isKidsSafe;

	public StoreSearch(double lat, double lng, double distance, String keyword, List<String> categories, List<String> isKidsSafe) {
		this.lat = lat;
		this.lng = lng;
		this.distance = distance;
		this.keyword = keyword;
		this.categories = categories;
		this.isKidsSafe = isKidsSafe;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public double getDistance() {
		return distance;
	}

	public String getKeyword() {
		return keyword;
	}

	public List<String> getCategories() {
		return categories;
	}
	
	public List<String> getIsKidsSafe() {
		return isKidsSafe;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setCategories() {
		this.categories = Arrays.asList(new String[] { "음식", "소매", "생활서비스", "부동산", "스포츠", "숙박", "학문/교육", "관광/여가/오락" });
	}

	@Override
	public String toString() {
		return "StoreSearch [lat=" + lat + ", lng=" + lng + ", distance=" + distance + ", keyword=" + keyword
				+ ", categories=" + categories + "]";
	}
}
