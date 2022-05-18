package com.ssafy.happyhouse.model;

public class FavoriteDto {

	private String memberId;
	private String dongCode;
	private String dongName;
	private String storeType;
	private String storeName;

	public FavoriteDto() {
	}

	public FavoriteDto(String memberId) {
		super();
		this.memberId = memberId;
	}

	public FavoriteDto(String memberId, String dongName) {
		super();
		this.memberId = memberId;
		this.dongName = dongName;
	}

	public FavoriteDto(String memberId, String dongCode, String dongName, String storeType, String storeName) {
		super();
		this.memberId = memberId;
		this.dongCode = dongCode;
		this.dongName = dongName;
		this.storeType = storeType;
		this.storeName = storeName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public String toString() {
		return String.format("%-15s\t %-15s\t %-15s\t %-50s\t %-50s\t", memberId, dongCode, dongName, storeType,
				storeName);

	}

}
