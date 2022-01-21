package com.dwav;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dwav.dao.UserDao;
import com.dwav.vo.SearchVO;
import com.dwav.vo.UserVO;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //applicationContext.xml loading
public class JUserDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserDao dao;
	
	
	UserVO user01;
	UserVO user02;
	UserVO user03;
	
	SearchVO searchVO;
	
	public void isSameUser(UserVO outVO, UserVO userVO) {
		
		assertEquals(outVO.getUser_id(), userVO.getUser_id());
		assertEquals(outVO.getFirst_name(), userVO.getFirst_name());
		assertEquals(outVO.getLast_name(), userVO.getLast_name());
		assertEquals(outVO.getUser_pwd(), userVO.getUser_pwd());
	}
	
	
	
	@Before
	public void setUp() throws Exception {
		
		searchVO = new SearchVO("","",10,1);
		
		user01 = new UserVO("physicskdh01","rlaehgud","Kim1","dohyoung","20121123","physicskdh@com1","020-9146-9869","asdasd","asdasd");
		user02 = new UserVO("physicskdh02","rlaehgud","Kim2","dohyoung","20121123","physicskdh@com2","030-9146-9869","asdasd","asdasd");
		user03 = new UserVO("physicskdh03","rlaehgud","Kim3","dohyoung","20121123","physicskdh@com3","010-9146-9869","asdasd","asdasd");
		
		LOG.debug("1=============================");
		LOG.debug("1context="+context);
		LOG.debug("1dao"+dao);
		LOG.debug("1=============================");
		assertNotNull(context);
		assertNotNull(dao);
		
	}
	
	@Test
	//@Ignore
	public void doRetrieve() throws SQLException{
		searchVO.setSearchDiv("");
		searchVO.setSearchWord("");
		List<UserVO> list = dao.doRetrieve(searchVO);
		//assertEquals(3,list.size());
	
			
		
		
	}
	
	
	public void doUpdate() throws SQLException{
		
		dao.deleteAll();
		
		int flag = dao.doInsert(user01);
		assertEquals(1,flag);
		
		String updateStr = "_U";
		int    upInt     = 10;
		
		
		user01.setFirst_name(user01.getFirst_name()+updateStr);
		// 차후에는, front에서 입력하는 값을 게터로 받아와서 여기에 넣어줘야겠지
		
		//4.
		flag = dao.doUpdate(user01);
		assertEquals(1, flag);
		
		
		//5.
		UserVO vsVO = dao.doSelectOne(user01);
		isSameUser(user01, vsVO);
		
		
	}
	
	@Test
	//@Ignore
	public void  getAll() throws SQLException{
		//1. 전체 삭제
		//2. 데이터 입력 3건
		//3. 전체건수 조회 = 3건
		
		//1.
		//dao.deleteAll();
		dao.doDelete(user01);
		dao.doDelete(user02);
		dao.doDelete(user03);
		//2.
		int flag = dao.doInsert(user01);
		assertEquals(flag, 1);
		
		flag += dao.doInsert(user02);
		assertEquals(flag, 2);
		
		flag += dao.doInsert(user03);
		assertEquals(flag, 3);	
		
		//3. 전체건수 조회 = 3건
		List<UserVO> list = dao.getAll();
		assertEquals(list.size(), 3);

	}
	
	
	
	//EmptyResultDataAccessException 예외가 발생하면 : 성공
	@Test//(expected = EmptyResultDataAccessException.class)
	//@Ignore
	public void getFailure() throws SQLException{
		LOG.debug("========================");
		LOG.debug("getFailure()");
		LOG.debug("========================");
		
		dao.deleteAll();
		dao.doInsert(user01);
		
	}
	
	
	//org.junit.runners.model.TestTimedOutException: test timed out after 1 milliseconds
	@Test
	//@Ignore
	public void addAndGet() {
		LOG.debug("==================");
		LOG.debug("addAndGet()");
		LOG.debug("==================");
		
		try {
			dao.deleteAll();
			
			
			dao.doInsert(user01);
			dao.doInsert(user02);
			dao.doInsert(user03);
			
			int addNum = dao.getCount();
			
			UserVO outVO01 = dao.doSelectOne(user01);
			isSameUser(outVO01,user01);
			
			UserVO outVO02 = dao.doSelectOne(user02);
			isSameUser(outVO02,user02);
			
			UserVO outVO03 = dao.doSelectOne(user03);
			isSameUser(outVO03,user03);
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	
	
	
	@After
	public void tearDown() throws Exception {
		LOG.debug("0==========================");
		LOG.debug("0=====tearDown()===========");
		LOG.debug("0==========================");
	
	}

}
