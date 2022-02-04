package com.dwav.vo;

public class ReviewVO {
	

private int review_id;
private int accom_id;
private String text;
private String user_id;
private int point;
private String title;

ReviewVO(){}
/**
 * @return the review_id
 */
public int getReview_id() {
	return review_id;
}
/**
 * @param review_id the review_id to set
 */
public void setReview_id(int review_id) {
	this.review_id = review_id;
}
/**
 * @return the accom_id
 */
public int getAccom_id() {
	return accom_id;
}
/**
 * @param accom_id the accom_id to set
 */
public void setAccom_id(int accom_id) {
	this.accom_id = accom_id;
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
/**
 * @return the user_id
 */
public String getUser_id() {
	return user_id;
}
/**
 * @param user_id the user_id to set
 */
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
/**
 * @return the point
 */
public int getPoint() {
	return point;
}
/**
 * @param point the point to set
 */
public void setPoint(int point) {
	this.point = point;
}
/**
 * @return the title
 */
public String getTitle() {
	return title;
}
/**
 * @param title the title to set
 */
public void setTitle(String title) {
	this.title = title;
}


@Override
public String toString() {
	return "ReviewVO [review_id=" + review_id + ", accom_id=" + accom_id + ", text=" + text + ", user_id=" + user_id
			+ ", point=" + point + ", title=" + title + ", getReview_id()=" + getReview_id() + ", getAccom_id()="
			+ getAccom_id() + ", getText()=" + getText() + ", getUser_id()=" + getUser_id() + ", getPoint()="
			+ getPoint() + ", getTitle()=" + getTitle() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
public ReviewVO(int review_id, int accom_id, String text, String user_id, int point, String title) {
	super();
	this.review_id = review_id;
	this.accom_id = accom_id;
	this.text = text;
	this.user_id = user_id;
	this.point = point;
	this.title = title;
}
 
	
	

}
