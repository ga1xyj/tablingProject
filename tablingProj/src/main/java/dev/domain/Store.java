package dev.domain;

import java.util.List;

public class Store {
	private String storeId;
	private String storeName;
	private String storeAddress;
	private String telephone;
	private int sitCapacity;
	private String availableTime;
	private int holiday;
	private String represnetMenu;
	private String foodCategory;
	private List<String> storeImgUrl;
	private String approvalStatus;
	private String memberId;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public List<String> getStoreImgUrl() {
		return storeImgUrl;
	}
	public void setStoreImgUrl(List<String> storeImgUrl) {
		this.storeImgUrl = storeImgUrl;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getSitCapacity() {
		return sitCapacity;
	}
	public void setSitCapacity(int sitCapacity) {
		this.sitCapacity = sitCapacity;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public int getHoliday() {
		return holiday;
	}
	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}
	public String getRepresnetMenu() {
		return represnetMenu;
	}
	public void setRepresnetMenu(String represnetMenu) {
		this.represnetMenu = represnetMenu;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
}
