package com.pcwk.domain;


public class ReviewVO {	
	
	private int reviewIdx;
	private int homeIdx;
	private int hostIdx;
	private int bookIdx;
	
	private String comment;

	private int clean;

	private int reviewComm;
	
	private int accuracy;
	
	private int satisfaction;
	
	private String reviewContents;
	
	private int userId;

	private String reviewDate;

	/**
	 * @return the reviewIdx
	 */
	public int getReviewIdx() {
		return reviewIdx;
	}

	/**
	 * @param reviewIdx the reviewIdx to set
	 */
	public void setReviewIdx(int reviewIdx) {
		this.reviewIdx = reviewIdx;
	}

	/*
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
	 * @return the hostIdx
	 */
	public int getHostIdx() {
		return hostIdx;
	}

	/**
	 * @param hostIdx the hostIdx to set
	 */
	public void setHostIdx(int hostIdx) {
		this.hostIdx = hostIdx;
	}

	/**
	 * @return the bookIdx
	 */
	public int getBookIdx() {
		return bookIdx;
	}

	/**
	 * @param bookIdx the bookIdx to set
	 */
	public void setBookIdx(int bookIdx) {
		this.bookIdx = bookIdx;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the clean
	 */
	public int getClean() {
		return clean;
	}

	/**
	 * @param clean the clean to set
	 */
	public void setClean(int clean) {
		this.clean = clean;
	}

	/**
	 * @return the reviewComm
	 */
	public int getReviewComm() {
		return reviewComm;
	}

	/**
	 * @param reviewComm the reviewComm to set
	 */
	public void setReviewComm(int reviewComm) {
		this.reviewComm = reviewComm;
	}

	/**
	 * @return the accuracy
	 */
	public int getAccuracy() {
		return accuracy;
	}

	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * @return the satisfaction
	 */
	public int getSatisfaction() {
		return satisfaction;
	}

	/**
	 * @param satisfaction the satisfaction to set
	 */
	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	/**
	 * @return the reviewContents
	 */
	public String getReviewContents() {
		return reviewContents;
	}

	/**
	 * @param reviewContents the reviewContents to set
	 */
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
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
	 * @return the reviewDate
	 */
	public String getReviewDate() {
		return reviewDate;
	}

	/**
	 * @param reviewDate the reviewDate to set
	 */
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "Review [reviewIdx=" + reviewIdx + ", homeIdx=" + homeIdx + ", hostIdx=" + hostIdx + ", bookIdx="
				+ bookIdx + ", comment=" + comment + ", clean=" + clean + ", reviewComm=" + reviewComm + ", accuracy="
				+ accuracy + ", satisfaction=" + satisfaction + ", reviewContents=" + reviewContents + ", userId="
				+ userId + ", reviewDate=" + reviewDate + "]";
	}

	public ReviewVO(int reviewIdx, int homeIdx, int hostIdx, int bookIdx, String comment, int clean, int reviewComm,
			int accuracy, int satisfaction, String reviewContents, int userId, String reviewDate) {
		super();
		this.reviewIdx = reviewIdx;
		this.homeIdx = homeIdx;
		this.hostIdx = hostIdx;
		this.bookIdx = bookIdx;
		this.comment = comment;
		this.clean = clean;
		this.reviewComm = reviewComm;
		this.accuracy = accuracy;
		this.satisfaction = satisfaction;
		this.reviewContents = reviewContents;
		this.userId = userId;
		this.reviewDate = reviewDate;
	}

	
	

	
	
	}

	

	

	
	

