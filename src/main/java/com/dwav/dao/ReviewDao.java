package com.dwav.dao;

import java.sql.SQLException;
import java.util.List;

import com.dwav.vo.SearchVO;
import com.dwav.vo.ReviewVO;


public interface ReviewDao {
	
	int doInsert(ReviewVO inVO) throws SQLException;

	/**
	 * 회원 조회
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	ReviewVO doSelectOne(ReviewVO inVO) throws SQLException;
	
	/**
	 * 회원 탈퇴
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doDelete(ReviewVO inVO)throws SQLException;
	
	/**
	 * 회원 정보 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doUpdate(ReviewVO inVO)throws SQLException;
	
	
	/**
	 * 유저 검색 조회 
	 * @param inVO
	 * @return List<ReviewVO>
	 * @throws SQLException
	 */
    List<ReviewVO>  doRetrieve(SearchVO inVO) throws SQLException;
    
    
    
}
	
	


