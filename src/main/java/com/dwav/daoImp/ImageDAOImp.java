package com.dwav.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwav.dao.ImageDAO;
import com.dwav.vo.BookingDateVO;
import com.dwav.vo.ImageVO;

@Repository
public class ImageDAOImp implements ImageDAO {

	
	@Autowired
	SqlSession session;
	
	@Override
	public int addImage(ImageVO img) {
		return session.insert("insertImage", img);
	}
	
	@Override
	public int addImageList(List<ImageVO> imgList) {
		int cnt = 0;
		for (ImageVO imgvo : imgList) {
			cnt += session.insert("insertImage", imgvo);
		}
		return cnt;
	}

	@Override
	public List<ImageVO> getImageByAccomId(int accom_id) {
		return session.selectList("getImageListByAccomId", accom_id);
	}

	@Override
	public int deleteImageByImageId(int image_id) {
		return session.delete("deleteImageByImageId", image_id);
	}

	

}
