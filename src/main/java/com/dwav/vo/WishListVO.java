package com.dwav.vo;

public class WishListVO {
	
	private int listIdx;
	private String homeImage;
	private String checkIn;
	private String checkOut;
	
	private String homeType;
	private String text;
	private int homeFacility;

	private int homeRule;
	
	private int homeIdx;
	
	private int userId;
	
	WishListVO(){}

	/**
	 * @return the listIdx
	 */
	public int getListIdx() {
		return listIdx;
	}

	/**
	 * @param listIdx the listIdx to set
	 */
	public void setListIdx(int listIdx) {
		this.listIdx = listIdx;
	}

	/**
	 * @return the homeImage
	 */
	public String getHomeImage() {
		return homeImage;
	}

	/**
	 * @param homeImage the homeImage to set
	 */
	public void setHomeImage(String homeImage) {
		this.homeImage = homeImage;
	}

	/**
	 * @return the checkIn
	 */
	public String getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public String getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * @return the homeType
	 */
	public String getHomeType() {
		return homeType;
	}

	/**
	 * @param homeType the homeType to set
	 */
	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	/**
	 * @return the homeFacility
	 */
	public int getHomeFacility() {
		return homeFacility;
	}

	/**
	 * @param homeFacility the homeFacility to set
	 */
	public void setHomeFacility(int homeFacility) {
		this.homeFacility = homeFacility;
	}

	/**
	 * @return the homeRule
	 */
	public int getHomeRule() {
		return homeRule;
	}

	/**
	 * @param homeRule the homeRule to set
	 */
	public void setHomeRule(int homeRule) {
		this.homeRule = homeRule;
	}

	/**
	 * @return the homeIdx
	 */
	public int getHomeIdx() {
		return homeIdx;
	}

	/**
	 * @param homeIdx the homeIdx to set
	 */
	public void setHomeIdx(int homeIdx) {
		this.homeIdx = homeIdx;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "WishListVO [listIdx=" + listIdx + ", homeImage=" + homeImage + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", homeType=" + homeType + ", text=" + text + ", homeFacility=" + homeFacility
				+ ", homeRule=" + homeRule + ", homeIdx=" + homeIdx + ", userId=" + userId + ", getListIdx()="
				+ getListIdx() + ", getHomeImage()=" + getHomeImage() + ", getCheckIn()=" + getCheckIn()
				+ ", getCheckOut()=" + getCheckOut() + ", getHomeType()=" + getHomeType() + ", getHomeFacility()="
				+ getHomeFacility() + ", getHomeRule()=" + getHomeRule() + ", getHomeIdx()=" + getHomeIdx()
				+ ", getUserId()=" + getUserId() + ", getText()=" + getText() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public WishListVO(int listIdx, String homeImage, String checkIn, String checkOut, String homeType, String text,
			int homeFacility, int homeRule, int homeIdx, int userId) {
		super();
		this.listIdx = listIdx;
		this.homeImage = homeImage;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.homeType = homeType;
		this.text = text;
		this.homeFacility = homeFacility;
		this.homeRule = homeRule;
		this.homeIdx = homeIdx;
		this.userId = userId;
	}
	
	
		
	
	
	}
