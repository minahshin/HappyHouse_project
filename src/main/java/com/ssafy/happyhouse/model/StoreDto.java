package com.ssafy.happyhouse.model;

public class StoreDto {
	private int id;
	private String name;
	private String category;
	private String dongCode;
	private String jibunAddress;
	private String doroAddress;
	private String zipCode;
	
	public StoreDto(int id, String name, String category, String dongCode, String jibunAddress, String doroAddress,
			String zipCode) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
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

	public String getCategory() {
		return category;
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

	@Override
	public String toString() {
		return id + "\t " + name + "\t " + category + "\t " + dongCode + "\t " + jibunAddress + "\t "
				+ doroAddress + " \t " + zipCode;
	}
	
	
}
