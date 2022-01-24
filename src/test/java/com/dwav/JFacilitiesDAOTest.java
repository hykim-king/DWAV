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
import org.springframework.test.context.web.WebAppConfiguration;

import com.dwav.dao.FacilitiesDAO;
import com.dwav.vo.FacilitiesVO;
import com.dwav.vo.SearchVO;






@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // applicationContext.xml loading
public class JFacilitiesDAOTest {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	ApplicationContext context;

	@Autowired
	FacilitiesDAO dao;

	FacilitiesVO facil01;
	FacilitiesVO facil02;
	FacilitiesVO facil03;

	SearchVO search;

	/**
	 * @param outVO
	 * @param facilVO
	 */
	public void isSameAmen(FacilitiesVO outVO, FacilitiesVO facilVO) {

		assertEquals(outVO.getAccom_id(), facilVO.getAccom_id());
		assertEquals(outVO.getAmen_id(), facilVO.getAmen_id());
		assertEquals(outVO.getAmenity_type(), facilVO.getAmenity_type());
		assertEquals(outVO.getAmenity_val(), facilVO.getAmenity_val());
	}

	@Before
	public void setUp() throws Exception {
		search = new SearchVO("", "", 10, 1);

		facil01 = new FacilitiesVO(1,1, "수영장", "수영장1");
		facil02 = new FacilitiesVO(2,1, "수영장", "수영장2");
		facil03 = new FacilitiesVO(3,1, "수영장", "수영장3");

		LOG.debug("0=============================");
		LOG.debug("0context=" + context);
		LOG.debug("0dao" + dao);
		LOG.debug("0=============================");
		assertNotNull(context);
		assertNotNull(dao);

	}

//	@Test
//	public void doUpdateAmen() throws SQLException {
//		LOG.debug("====================");
//		LOG.debug("=doUpdate()=");
//		LOG.debug("====================");
//		
//		dao.deleteAllAmen();
//
//		int flag = dao.doInsertAmen(facil01);
//		assertEquals(1, flag);
//		assertEquals(1,dao.getCountAmen());
//
//		FacilitiesVO vsFacil = dao.findAccom(facil01);
//		isSameAmen(dao.doSelectAmen(vsFacil), facil01);
//		
//		
//		
//		String updateStr = "_U";
//		int upInt = 10;
//
//		vsFacil.setAccom_id(vsFacil.getAccom_id() + upInt);	
//		vsFacil.setAmenity_type(vsFacil.getAmenity_type() + updateStr);	
//		vsFacil.setAmenity_val(vsFacil.getAmenity_val() + updateStr);	
//			
//		//4.
//		flag = dao.doUpdateAmen(vsFacil);
//		assertEquals(1, flag);
//		
//		
//		//5.
//		FacilitiesVO upFacilVO = dao.doSelectAmen(vsFacil);
//		isSameAmen(vsFacil, upFacilVO);
//		
//		
//	}

	
	
	@Test
	public void RetrieveAmen() throws SQLException{
		LOG.debug("====================");
		LOG.debug("=doRetrieveAmen()=");
		LOG.debug("====================");
		
		search.setPageNum(1);
		search.setPageSize(3);
		search.setSearchDiv("30");
		search.setSearchWord("수영장");
		
		List<FacilitiesVO> list = dao.doRetrieveAmen(search);
		assertEquals(3, list.size());
	}
	

	@Test
	public void getAll() throws SQLException {
		
		LOG.debug("==================");
		LOG.debug("getAll()");
		LOG.debug("==================");
		
		dao.doDeleteAmen(facil01);
		dao.doDeleteAmen(facil02);
		dao.doDeleteAmen(facil03);
		
		
		int flag = dao.doInsertAmen(facil01);
		assertEquals(flag, 1);
		
		flag += dao.doInsertAmen(facil02);
		assertEquals(flag, 2);
		
		flag += dao.doInsertAmen(facil03);
		assertEquals(flag, 3);
		
		List<FacilitiesVO> list = dao.getAllAmen();
		assertEquals(list.size(), 3);
	}
	

	
	
}
