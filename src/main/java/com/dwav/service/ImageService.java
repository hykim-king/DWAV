package com.dwav.service;

import java.sql.SQLException;

import com.dwav.vo.ImageVO;

public interface ImageService {
	
	
	ImageVO SelectImg(ImageVO inVO) throws SQLException;



	/**
	 * 숙소 등록 
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int InsertImg(ImageVO inVO) throws SQLException;
	
	
	/**
	 * 단건 삭제
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int DeleteImg(ImageVO inVO)throws SQLException;
	

}
