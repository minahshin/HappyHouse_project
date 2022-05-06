package com.ssafy.happyhouse.model;

public class StoreDtoDistance extends StoreDto{

	private double distance;
	
	public StoreDtoDistance(int id, String name, String bigType, String mediumType, String storeType, String dongCode,
			String jibunAddress, String doroAddress, String zipCode) {
		super(id, name, bigType, mediumType, storeType, dongCode, jibunAddress, doroAddress, zipCode);
	}

	public StoreDtoDistance(int id, String name, String bigType, String mediumType, String storeType, String dongCode,
			String jibunAddress, String doroAddress, String zipCode, double distance) {
		super(id, name, bigType, mediumType, storeType, dongCode, jibunAddress, doroAddress, zipCode);
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
