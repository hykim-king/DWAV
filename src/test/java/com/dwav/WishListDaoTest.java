package com.dwav;

import static org.junit.Assert.*;

import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dwav.dao.WishListDao;
import com.dwav.vo.WishListVO;
import com.dwav.vo.SearchVO;

@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //applicationContext.xml loading
public class WishListDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	
	
	@Autowired
	WishListDao dao;
	
	WishListVO WishList01;
	WishListVO WishList02;
	WishListVO WishList03;
	
	SearchVO searchVO;
	
	public void isSameWishList(WishListVO outVO, WishListVO WishListVO) {
		
		assertEquals(outVO.getListIdx() ,WishListVO.getListIdx());
		assertEquals(outVO.getHomeImage(), WishListVO.getHomeImage());
		assertEquals(outVO.getCheckIn(), WishListVO.getCheckIn());
		assertEquals(outVO.getCheckOut(), WishListVO.getCheckOut());
		assertEquals(outVO.getHomeType(), WishListVO.getHomeType());
		assertEquals(outVO.getHomeFacility(), WishListVO.getHomeFacility());
		assertEquals(outVO.getHomeRule(), WishListVO.getHomeRule());
		assertEquals(outVO.getUserId(), WishListVO.getUserId());
		assertEquals(outVO.getHomeIdx(), WishListVO.getHomeIdx());
	}
	

	@Before
	public void setUp() throws Exception {
		searchVO = new SearchVO("","",10,1);
		
		WishList01 = new WishListVO(1,"A","B","C","D","E",5,6,7,8);
		WishList02 = new WishListVO(2,"AA","BB","CC","DD","EE",9,10,11,12);
		WishList03 = new WishListVO(3,"AAA","BBB","CCC","DDD","EEE",13,14,15,16);
		
		LOG.debug("1=============================");
		LOG.debug("1context="+context);
		LOG.debug("1dao"+dao);
		LOG.debug("1=============================");
		assertNotNull(context);
		assertNotNull(dao);
		
	}

	@Test
public void doInsert() throws SQLException {
		
		LOG.debug("1=============================");
		LOG.debug("doInsert");
		LOG.debug("1=============================");

		dao.dodeleteWishList(WishList01);
		dao.dodeleteWishList(WishList02);
		dao.dodeleteWishList(WishList03);
		
		dao.doInsertWishList(WishList01);
		dao.doInsertWishList(WishList02);
		dao.doInsertWishList(WishList03);
	}
	
	@Test
public void doUpdate() throws SQLException {
		
		dao.dodeleteWishList(WishList01); dao.dodeleteWishList(WishList02);
		dao.dodeleteWishList(WishList03);
		
		
		int flag = dao.doInsertWishList(WishList01); assertEquals(1,flag);
		 
		
		WishList01.setText(WishList01.getText()+"안녕하세요");
		
		dao.doInsertWishList(WishList01);
	}
	/*
	 * @Test public void doRetrieve() throws SQLException{
	 * 
	 * searchVO.setSearchDiv("30"); searchVO.setSearchWord("TEST");
	 * 
	 * List<WishListVO> list = dao.doRetrieveWishList(searchVO);
	 * assertEquals(10,list.size());
	 * 
	 * }
	 */

}
