package com.dwav.dao;

import java.util.List;

import com.dwav.vo.BookingDateVO;

public interface BookingDateDAO {
//	CRUDs
	public int insertBookingDate(BookingDateVO BookingDate);
	public int deleteBookingDateByBookingDateId(int rdId);
	public int deleteBookingDateListByBookingDates(int reserv_id, String startDate, String endDate);
	
//	Functional Method
	public int insertBookingDateList(List<BookingDateVO> BookingDateList);
	public List<BookingDateVO> getBookingDateListByHomeId(int HomeId);
	public List<BookingDateVO> getBookingDateListByDates(String startDate, String endDate);
	
}
