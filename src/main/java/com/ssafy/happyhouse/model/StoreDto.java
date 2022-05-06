package com.ssafy.happyhouse.model;

public class StoreDto {
	private int id;
	private String name;
	private String bigType;
	private String mediumType;
	private String storeType;
	private String dongCode;
	private String jibunAddress;
	private String doroAddress;
	private String zipCode;

	public StoreDto(int id, String name, String bigType, String mediumType, String storeType, String dongCode,
			String jibunAddress, String doroAddress, String zipCode) {
		this.id = id;
		this.name = name;
		this.bigType = bigType;
		this.mediumType = mediumType;
		this.storeType = storeType;
		this.dongCode = dongCode;
		this.jibunAddress = jibunAddress;
		this.doroAddress = doroAddress;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBigType() {
		return bigType;
	}

	public String getMediumType() {
		return mediumType;
	}

	public String getStoreType() {
		return storeType;
	}

	public String getDongCode() {
		return dongCode;
	}

	public String getJibunAddress() {
		return jibunAddress;
	}

	public String getDoroAddress() {
		return doroAddress;
	}

	public String getZipCode() {
		return zipCode;
	}	
	
}
