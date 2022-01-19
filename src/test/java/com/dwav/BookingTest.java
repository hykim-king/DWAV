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

import com.dwav.dao.BookingDAO;
import com.dwav.dao.BookingDateDAO;
import com.dwav.dao.HomeDAO;
import com.dwav.vo.BookingVO;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BookingTest {
	final Logger  LOG = LogManager.getLogger(getClass());

    

	

	
	@Autowired
	BookingDAO reservdao;
	
	
	
//		**ADD** ORA-32795: generated always ID 열에 삽입할 수 없습니다.
	@Test
	public void test() {
		LOG.debug("add Booking result : " + 
				reservdao.insertBooking(
						new BookingVO(1, "2021-06-06", 4, "2021-06-05", "lhs", 5000, "pjs")
						)
		);
	}
//		
//		  accom_id, end_date, number_of_people, start_date, user_id, price, host_id)
//		
////		**RETRIEVE**
	@Test
	public void test1() {
		LOG.debug(reservdao.getBookingListByUserId("test"));
		LOG.debug(reservdao.getBookingListByHostId("pjs"));
		}
	
	
	
////	**UPDATE** java.lang.IndexOutOfBoundsException: Index: 1, Size: 0		
	@Test
	public void test2() {
		List<BookingVO> rsrvList = reservdao.getBookingListByUserId("123");
		LOG.debug(rsrvList);
		rsrvList.get(1).setStart_date("2021-06-01");
		rsrvList.get(1).setEnd_date("2021-06-02");
		reservdao.updateBooking(rsrvList.get(1));
		reservdao.updateBooking(rsrvList.get(12));
	}
		
//
////		**FUNCTIONAL***
////		NOTI_HOST    java.lang.NullPointerException
	@Test
	public void test3() {
		
		LOG.debug("getNotiHostByReservID result : " + reservdao.getNotiHostByReservID(7));
		LOG.debug("confirmNotiHostByReservID AFFECTED ROWS : " + reservdao.confirmNotiHostByReservID(7));
		LOG.debug("getNotiHostByReservID result : " + reservdao.getNotiHostByReservID(7));
		
	}
//		
////		NOTI_CONFIRMED java.lang.NullPointerException
	@Test
	public void test4() {
		LOG.debug("getNotiConfirmedByReservID result : " + reservdao.getNotiConfirmedByReservID(7));
		LOG.debug("confirmNotiHostByReservID AFFECTED ROWS : " + reservdao.confirmedNotiConfirmedByReservID(7));
		LOG.debug("getNotiConfirmedByReservID result : " + reservdao.getNotiConfirmedByReservID(7));
		LOG.debug("confirmNotiHostByReservID AFFECTED ROWS : " + reservdao.deniedNotiConfirmedByReservID(7));
		LOG.debug("getNotiConfirmedByReservID result : " + reservdao.getNotiConfirmedByReservID(7));
	}
////		Reset NOTI_HOST, NOTI_CONFIMED by UPDATE java.lang.NullPointerException
	
	@Test
	public void test5() {	 
		BookingVO rsrv = reservdao.getBookingByReservId(7);
		reservdao.updateBooking(rsrv);
		LOG.debug("After updateBooking result NOTI_HOST : " + reservdao.getNotiHostByReservID(7));
		LOG.debug("After updateBooking result NOTI_CONFIRMED : " + reservdao.getNotiConfirmedByReservID(7));

	}

}
