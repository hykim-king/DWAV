package com.dwav;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

import com.dwav.dao.BookingDAO;
import com.dwav.dao.BookingDateDAO;
import com.dwav.dao.FacilitiesDAO;
import com.dwav.dao.HomeDAO;
import com.dwav.dao.ImageDAO;
import com.dwav.vo.BookingDateVO;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BookingDateTest {
	final Logger  LOG = LogManager.getLogger(getClass());
	
	@Autowired
	HomeDAO adao;
	
	@Autowired
	BookingDateDAO rddao;
	
	@Autowired
	BookingDAO reservdao;
	
	
	
	
	
//		-----------------------BookingDate TESTER--------------------------

	//		**ADD**   
	@Test
	public void test1() {
		rddao.insertBookingDate(new BookingDateVO());
		List<BookingDateVO> rd = rddao.getBookingDateListByHomeId(1);
		for(BookingDateVO f : rd) {
			LOG.debug(f);
		}
	}
//		
		
	@Test
	public void test2() {
////		**ADD BY LIST**  null 오류
		List<BookingDateVO> BookingDateList = new ArrayList<>();
		BookingDateList.add(new BookingDateVO());
		BookingDateList.add(new BookingDateVO());
		BookingDateList.add(new BookingDateVO());
		
		int resultRDL = rddao.insertBookingDateList(BookingDateList);
		LOG.debug("RDL inserted : " + resultRDL);
    }
	
	@Test
	public void test3() {
////ok		**RETRIEVE between DATES** 
		List<BookingDateVO> il = rddao.getBookingDateListByDates("2021-05-01", "2021-05-05");
		for (BookingDateVO reservedDateVO : il) {
			LOG.debug(reservedDateVO);
		}
  	}
	@Test
	public void test4() {
////		**DELETE**
		rddao.deleteBookingDateByBookingDateId(1);
	}

}
