package com.dwav.vo;

public class ImageVO {
	int image_id;
	int accom_id;
	String path;
	
	public ImageVO(){}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public int getAccom_id() {
		return accom_id;
	}

	public void setAccom_id(int accom_id) {
		this.accom_id = accom_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ImageVO [image_id=" + image_id + ", accom_id=" + accom_id + ", path=" + path + ", toString()="
				+ super.toString() + "]";
	}

	public ImageVO(int image_id, int accom_id, String path) {
		super();
		this.image_id = image_id;
		this.accom_id = accom_id;
		this.path = path;
	}

 
	
	
}
