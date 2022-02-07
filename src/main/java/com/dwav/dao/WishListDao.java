package com.dwav.dao;

import java.sql.SQLException;
import java.util.List;

import com.dwav.vo.WishListVO;
import com.dwav.vo.SearchVO;



public interface WishListDao {
	
	int doInsertWishList(WishListVO inVO) throws SQLException;
	
	WishListVO doSelectWishList(WishListVO inVO) throws SQLException;

	int dodeleteWishList(WishListVO inVO)throws SQLException;
	
	int doupdateWishList(WishListVO inVO)throws SQLException;
	
	/* List<WishListVO> doRetrieveWishList(SearchVO inVO) throws SQLException; */

}
