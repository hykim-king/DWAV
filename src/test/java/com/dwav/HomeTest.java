package com.dwav;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dwav.dao.HomeDAO;
import com.dwav.vo.HomeVO;




@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
							       "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class HomeTest {
	final Logger  LOG = LogManager.getLogger(getClass());
	
	@Autowired
	HomeDAO adao;
	
	HomeVO hvo01;
	HomeVO hvo02;
	
	@Test
	public void test1() {
		adao.insertHome(new HomeVO(
				4,1,2,2,"빌라","원","학원설명입니다. 1,2,3 마이크 테스트", "test", "서울시 영등포구 한경닷컴401", 
				"test의 숙박지", 70000, "집", "개인실"));
		adao.insertHome(new HomeVO(
				3,1,2,2,"아파트","원","학원", "test", "서울시 영등포구 한경닷컴402", 
				"test의 숙박지2", 80000, "학원", "개인실"));
	}
	
	@Test //ok
	public void test2() {
		LOG.debug(adao.getHome(1));
		
	}
	@Test //ok
	public void test3() {
		LOG.debug("DELETE AFFECTED ROWS : " + adao.deleteHome(2));
	}
	
	@Test   //java.lang.NullPointerException
	public void test4() {
		HomeVO avo = adao.getHome(2);
		avo.setName("test의 하숙집");
		LOG.debug("===================================================");
		LOG.debug("avo"+avo);   
		LOG.debug("==================================================");
		adao.updateHome(avo);
	}

	@Test
	public void test5() {
		List<HomeVO> searchlist = adao.getHomeListBySearchBar("서울시", "2021-01-02", "2021-04-30", 1);
		for (HomeVO HomeVO : searchlist) {
			LOG.debug(HomeVO);
		}
	}
	
	
}
