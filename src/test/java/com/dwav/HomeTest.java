package com.dwav;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.core.IsSame;
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



import com.dwav.dao.HomeDao;
import com.dwav.vo.HomeVO;
import com.dwav.vo.SearchVO;


<<<<<<< HEAD
=======

>>>>>>> 130ebcfb197275a9f3e0dc0e667afae0bfb27a2d
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
							       "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class HomeTest {
	final Logger  LOG = LogManager.getLogger(getClass());
	
	@Autowired
    ApplicationContext  context;
	
	@Autowired
	HomeDao dao;
	
	HomeVO home01;
	HomeVO home02;
	HomeVO home03;
	
<<<<<<< HEAD
	
	
	@Before
	public void setup()throws Exception {
=======
	SearchVO  search;
	
	@Before
	public void setup()throws Exception {
		search = new SearchVO("", "", 10, 1);
>>>>>>> 130ebcfb197275a9f3e0dc0e667afae0bfb27a2d
		LOG.debug("1====================");
		LOG.debug("1=context="+context);
		LOG.debug("1=dao="+dao);
		LOG.debug("1====================");
		
		home01 = new HomeVO(1, 1, 1, 1, "방명록", "안", "서울시", 70000, "주택", "복층", 2, "프라이빗", "원", "테스트집", 0);
		home02 = new HomeVO(2, 2, 2, 2, "test집", "test", "서울시", 70000, "개인주택", "일반방", 5, "개인", "원", "테스트",0);
		home03 = new HomeVO(3, 3, 3, 3, "", "test3", "서울시", 80000, "집", "집", 2, "집", "원", "테스트3집",0);
				
				
				
				
		assertNotNull(context);
		assertNotNull(dao);
		
	}

	@Test
//	@Ignore
	public void addAndGet() throws SQLException{
		LOG.debug("====================");
		LOG.debug("=====addAndGet======");
		LOG.debug("====================");

		
		
		try {
			
			//1	
			dao.deleteHomeAll();
			
			//2
			int flag = dao.InsertHome(home01);
		    assertEquals(1, flag);
		    assertEquals(1, dao.getHomeCount());
		    
		    HomeVO vsHome = dao.locationLike(home01);
		    isSameHome(dao.SelectHome(vsHome), home01);
		    
		    flag = dao.DeleteHome(vsHome);
		    assertEquals(1, flag);
			assertEquals(0, dao.getHomeCount());   
			
		
		
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	@Test 
//	@Ignore
	public void getAllHome() throws SQLException{
		
		
		dao.deleteHomeAll();
	
		//2.
		int flag = dao.InsertHome(home01);
		assertEquals(flag, 1);
		
		flag += dao.InsertHome(home02);
		assertEquals(flag, 2);
		
		flag += dao.InsertHome(home03);
		assertEquals(flag, 3);	
		
		//3. 전체건수 조회 = 3건
		List<HomeVO> list = dao.getAll();
		assertEquals(list.size(), 3);
		
		
	}
	
	@Test
//	@Ignore
	public void doUpdate() throws SQLException {
	  //1. 전체삭제
	  //2. 신규등록: home01
	  //3. home01수정
	  //4. home01데이터 update
	  //5. 1건조회후 서로 비교 home01
		LOG.debug("====================");
		LOG.debug("====doUpdate======");
		LOG.debug("====================");
		//1. 
		dao.deleteHomeAll();
		
		//2.
		int flag = dao.InsertHome(home01);
		assertEquals(1, flag);
		assertEquals(1, dao.getHomeCount());
		
		HomeVO vsHome = dao.locationLike(home01);
		isSameHome(dao.SelectHome(vsHome), home01);
		
		//3.
		String updateStr = "_U";
		int    upInt     = 5;
		
		
		home01.setAccomodates(     home01.getAccomodates()  +upInt);
		home01.setBathrooms(       home01.getBathrooms()    +upInt);
		home01.setBedrooms(        home01.getBedrooms()     +upInt);
		home01.setDescrption(      home01.getDescrption()   +updateStr);
		home01.setHost_Id(         home01.getHost_Id()      +updateStr);
		home01.setLocation(        home01.getLocation()     +updateStr);
		home01.setPrice(           home01.getPrice()        +upInt);
		home01.setProperty_Type(   home01.getProperty_Type()+updateStr);
		home01.setRoom_Type(       home01.getRoom_Type()	+updateStr);	
		home01.setBeds(  		   home01.getBeds()	        +upInt);
		home01.setBuilding_Type(   home01.getBuilding_Type()+updateStr);		
		home01.setCurrency_Unit(   home01.getCurrency_Unit()+updateStr);		
		home01.setName(            home01.getName()         +updateStr);
		home01.setAvg_Point(       home01.getAvg_Point()	+upInt);
		
		//4.수정
		flag = dao.UpdateHome(vsHome);
		assertEquals(1, flag);
		
		
//		HomeVO upHomeVO = dao.SelectHome(home01);
//		isSameHome(vsHome, upHomeVO);
		
	}
	@Test
	public void getHomeListBySearchBar() {
		List<HomeVO> searchlist = dao.getHomeListBySearchBar("서울시", "2021-01-02", "2021-04-30", 1);
		for (HomeVO HomeVO : searchlist) {
			LOG.debug(HomeVO);
		}
	}
	
	@Test
	public void RetrieveHome()throws SQLException{
		search.setPageNum(1);
		search.setPageSize(20);
		search.setSearchDiv("20");
		search.setSearchWord("서울");
		List<HomeVO> list = dao.RetrieveHome(search);
		assertEquals(3, list.size());
	}
	
	private void isSameHome(HomeVO outVO, HomeVO homeVO) {
		
		assertEquals(outVO.getName(),          homeVO.getName());
		assertEquals(outVO.getAccomodates(),   homeVO.getAccomodates());
		assertEquals(outVO.getBathrooms(),     homeVO.getBathrooms());
		assertEquals(outVO.getBedrooms(),      homeVO.getBedrooms());
		assertEquals(outVO.getDescrption(),    homeVO.getDescrption());
		assertEquals(outVO.getHost_Id(),       homeVO.getHost_Id());
		assertEquals(outVO.getLocation(),      homeVO.getLocation());
		assertEquals(outVO.getPrice(),         homeVO.getPrice());
		assertEquals(outVO.getProperty_Type(), homeVO.getProperty_Type());
		assertEquals(outVO.getRoom_Type(),     homeVO.getRoom_Type());		
		assertEquals(outVO.getBeds(), 		   homeVO.getBeds());		
		assertEquals(outVO.getBuilding_Type(), homeVO.getBuilding_Type());		
		assertEquals(outVO.getCurrency_Unit(), homeVO.getCurrency_Unit());		
		assertEquals(outVO.getName(),          homeVO.getName());		
		assertEquals(outVO.getAvg_Point(),     homeVO.getAvg_Point());		
	
		
		
	}
}
