package com.dwav.dao;

import java.util.List;

import com.dwav.vo.ImageVO;

public interface ImageDAO {
	// CRUDs
	public int addImage(ImageVO img);
	public int addImageList(List<ImageVO> imgList);
	public List<ImageVO> getImageByAccomId(int accom_id);
	public int deleteImageByImageId(int image_id);
	
	// Functional Methods
}
