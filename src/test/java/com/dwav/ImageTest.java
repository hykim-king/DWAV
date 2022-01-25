package com.dwav;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import com.dwav.dao.HomeDao;
import com.dwav.dao.ImageDao;
<<<<<<< HEAD
import com.dwav.vo.HomeVO;
=======
>>>>>>> 130ebcfb197275a9f3e0dc0e667afae0bfb27a2d
import com.dwav.vo.ImageVO;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class ImageTest {
	final Logger  LOG = LogManager.getLogger(getClass());
	
	
	@Autowired
    ApplicationContext  context;
	
	@Autowired
	ImageDao dao;
	
	ImageVO imgvo01;
	ImageVO imgvo02;
	ImageVO imgvo03;

	
	@Before
	public void setup()throws Exception {
		LOG.debug("1====================");
		LOG.debug("1=context="+context);
		LOG.debug("1=dao="+dao);
		LOG.debug("1====================");
	
		imgvo01 = new ImageVO(1,1, "web-file");
		
		assertNotNull(context);
		assertNotNull(dao);
		
	}
	
	@Test
//	@Ignore
	public void addAndGet() throws SQLException{
		LOG.debug("====================");
		LOG.debug("=====addAndGet======");
		LOG.debug("====================");
		
		dao.deleteImgAll();
		
		dao.InsertImg(imgvo01);
		dao.SelectImg(imgvo01);
		dao.DeleteImg(imgvo01);
	}
	
	
	
}
