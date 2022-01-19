package com.dwav;

import static org.junit.Assert.*;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dwav.dao.FacilitiesDAO;
import com.dwav.vo.FacilitiesVO;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class FacilitiesTest {

	final Logger  LOG = LogManager.getLogger(getClass());
	
	@Autowired
	FacilitiesDAO amendao;

	@Test //Amenity**ORA-32795: generated always ID 열에 삽입할 수 없습니다.
	public void test1() {
		LOG.debug("addAmenity INSERTED ROWS : " + amendao.addAmenity(new FacilitiesVO(1, "Wi-Fi")));
		
	}
	@Test //오류
	public void test2() {
		List<FacilitiesVO> aVOList = new ArrayList<>();
		aVOList.add(new FacilitiesVO(1, "편의시설",  "무선인터넷"));
		aVOList.add(new FacilitiesVO(1, "공간", "수영장"));
		aVOList.add(new FacilitiesVO(1, "좋은점", "반려동물 동반"));
		LOG.debug("addAmenity INSERTED ROWS : " + amendao.addAmenityList(aVOList));
	}
	@Test //오류
	public void test3() {
		List<FacilitiesVO> raVOList = new ArrayList<>();
		raVOList = amendao.getAmenityListByAccomID(1);
		for (FacilitiesVO amenityVO : raVOList) {
			LOG.debug(amenityVO);
		}
	}
		
	@Test //
	public void test4() {
		List<FacilitiesVO> aVOList1 = new ArrayList<>();
		aVOList1.add(new FacilitiesVO(1, "편의시설", "Wi-Fi"));
		aVOList1.add(new FacilitiesVO(1, "편의시설", "수면등"));
		aVOList1.add(new FacilitiesVO(1, "편의시설", "DVD"));
		LOG.debug("updateAmentiy AFFECTED ROWS : " + amendao.updateAmentiyList(1, aVOList1));
		
	}
	
}
