package com.dwav;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dwav.dao.ReviewDao;
import com.dwav.vo.SearchVO;
import com.dwav.vo.ReviewVO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //applicationContext.xml loading

public class ReviewDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	ReviewDao dao;
	
	ReviewVO review01;
	ReviewVO review02;
	ReviewVO review03;
	
	SearchVO searchVO;
	
public void isSameReview(ReviewVO outVO, ReviewVO ReviewVO) {
	
		assertEquals(outVO.getReview_id() ,ReviewVO.getReview_id());
		assertEquals(outVO.getAccom_id(), ReviewVO.getAccom_id());
		assertEquals(outVO.getText(), ReviewVO.getText());
		assertEquals(outVO.getUser_id(), ReviewVO.getUser_id());
		assertEquals(outVO.getPoint(), ReviewVO.getPoint());
		assertEquals(outVO.getTitle(), ReviewVO.getTitle());
	}
	


	@Before
	public void setUp() throws Exception {
		searchVO = new SearchVO("","",10,1);
		
		review01 = new ReviewVO(22,1,"TEST1","TEST1",5,"가평펜션1");
		review02 = new ReviewVO(2,1,"TEST2","TEST2",6,"가평펜션2");
		review03 = new ReviewVO(3,2,"TEST3","TEST3",7,"가평펜션3");
		
		LOG.debug("1=============================");
		LOG.debug("1context="+context);
		LOG.debug("1dao"+dao);
		LOG.debug("1=============================");
		assertNotNull(context);
		assertNotNull(dao);
		
	}

	@Test
	@Ignore
	public void doInsert() throws SQLException {
		
		LOG.debug("1=============================");
		LOG.debug("doInsert");
		LOG.debug("1=============================");

		dao.dodeleteReview(review01);
		dao.dodeleteReview(review02);
		dao.dodeleteReview(review03);
		
		dao.doInsertReview(review01);
		dao.doInsertReview(review02);
		dao.doInsertReview(review03);
		
	}

	@Test
	@Ignore
	public void doDelete() throws SQLException {
		dao.dodeleteReview(review01);
		dao.dodeleteReview(review02);
		
		
	}
	
	@Test
	@Ignore
	public void doUpdate() throws SQLException {
		
		dao.dodeleteReview(review01); dao.dodeleteReview(review02);
		dao.dodeleteReview(review03);
		
		
		 int flag = dao.doInsertReview(review01); assertEquals(1,flag);
		 
		
		review01.setText(review01.getText()+"안녕하세요");
		
		dao.doInsertReview(review01);
	}


	@Test
	//@Ignore
	public void doRetrieve() throws SQLException{
		
		searchVO.setSearchDiv("30");
		searchVO.setSearchWord("TEST");
		
		List<ReviewVO> list = dao.doRetrieveReview(searchVO);
		assertEquals(10,list.size());
	}


}
