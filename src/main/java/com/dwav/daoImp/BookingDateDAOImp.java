package com.dwav.daoImp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwav.dao.BookingDateDAO;
import com.dwav.vo.BookingDateVO;


@Repository
public class BookingDateDAOImp implements BookingDateDAO {
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insertBookingDate(BookingDateVO BookingDate) {
		return session.insert("insertBookingDate", BookingDate);
	}
	
	@Override
	public List<BookingDateVO> getBookingDateListByHomeId(int HomeId) {
		return session.selectList("getBookingDateListByHomeId", HomeId);
	}

	@Override
	public List<BookingDateVO> getBookingDateListByDates(String startDate, String endDate) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("startDate", startDate);
		parameters.put("endDate", endDate);
		
		return session.selectList("getBookingDateIdListByDates", parameters);
	}

	@Override
	public int insertBookingDateList(List<BookingDateVO> BookingDateList) {
		int cnt = 0;
		for (BookingDateVO BookingDateVO : BookingDateList) {
			cnt += session.insert("insertBookingDate", BookingDateVO);
		}
		return cnt;
	}

	@Override
	public int deleteBookingDateByBookingDateId(int rdId) {
		return session.delete("deleteBookingDateByBookingDateId", rdId);
	}

	@Override
	public int deleteBookingDateListByBookingDates(int reserv_id, String startDate, String endDate) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("reserv_id", reserv_id);
		parameters.put("startDate", startDate);
		parameters.put("endDate", endDate);
		
		return session.delete("deleteBookingDateListByBookingDates", parameters);
	}

	

}
