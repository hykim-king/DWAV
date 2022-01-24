package com.pcwk.persistence;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pcwk.domain.WishListVO;;

public interface WishListDao {
	
	List<WishListVO> listIdx(WishListVO inVO) throws SQLException;

	List<WishListVO> homeImg(WishListVO inVO) throws SQLException;

	List<WishListVO> checkIn(WishListVO inVO) throws SQLException;

	List<WishListVO> checkOut(WishListVO inVO) throws SQLException;
	
	List<WishListVO> homeType(WishListVO inVO) throws SQLException;
	
	List<WishListVO> homeFacility(WishListVO inVO) throws SQLException;
	
	List<WishListVO> homeRule(WishListVO inVO) throws SQLException;
	
	List<WishListVO> homeIdx(WishListVO inVO) throws SQLException;
	
	List<WishListVO> userId(WishListVO inVO) throws SQLException;

}