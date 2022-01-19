package com.dwav.dao;

import java.util.List;

import com.dwav.vo.BookingDateVO;
import com.dwav.vo.BookingVO;

public interface BookingDAO {
//	CRUDs
	public List<String> insertBooking(BookingVO reserv);
	public BookingVO getBookingByReservId(int reserv_Id);
	public List<BookingVO>getBookingListByUserId(String user_Id);
	public List<BookingVO>getBookingListByHostId(String host_Id);
	public List<BookingVO>getBookingListByAcoomId(int accom_Id);
	public int updateBooking(BookingVO reserv); // set NotiHost 0, NotiConfirmed 0
	public int deleteBookingBybookingId(int reservationId);
	
//	Functional Method
	public int getNotiHostByReservID(int reserv_id);
	public int confirmNotiHostByReservID(int reserv_id); // 1
	public int getNotiConfirmedByReservID(int reserv_id);
	public int confirmedNotiConfirmedByReservID(int reserv_id); // 1
	public int deniedNotiConfirmedByReservID(int reserv_id); // 2 
}