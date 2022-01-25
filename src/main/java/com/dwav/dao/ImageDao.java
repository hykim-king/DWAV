package com.dwav.dao;

import java.sql.SQLException;
import java.util.List;

import com.dwav.vo.HomeVO;
import com.dwav.vo.ImageVO;

public interface ImageDao {
	// CRUDs
	
	ImageVO SelectImg(ImageVO inVO) throws SQLException;

	/**
	 * 전체 삭제 
	 * @throws SQLException
	 */
	void deleteImgAll() throws SQLException;

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
