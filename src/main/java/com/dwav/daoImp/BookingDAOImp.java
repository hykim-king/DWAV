package com.dwav.daoImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwav.dao.BookingDAO;
import com.dwav.util.DateMaker;
import com.dwav.vo.BookingDateVO;
import com.dwav.vo.BookingVO;

@Repository
public class BookingDAOImp implements BookingDAO {

	@Autowired
	SqlSession session;

	@Override
	public List<String> insertBooking(BookingVO reserv) {
		/**
		 * 출력용 메소드 입니다.
		 * @param BookingVO Booking 테이블에 추가할 예약정보가 담긴 VO
		 * @return 성공 [TRUE, Insert된 ROW갯수], 예약날짜가 겹치면 [FALSE, 겹친날짜의 String...]
		 */

		List<String> resultList = new ArrayList<>();
		
		String sDate = reserv.getStart_date();
		String eDate = reserv.getEnd_date();

		// 예약일의 시작~끝일까지의 날짜리스트를 생성
		List<String> dateList = DateMaker.getDateList(sDate, eDate);

		// 날짜리스트가 중복 되는지 확인
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("accom_id", reserv.getAccom_id());
		parameters.put("startDate", sDate);
		parameters.put("endDate", eDate);
		List<BookingDateVO> rdList = session.selectList("checkBookingDate", parameters);
		if (!rdList.isEmpty()) // 중복된 날짜가 하루라도 있다면, 예약 불가능
		{
			resultList.add("FALSE");
			for (BookingDateVO reservedDateVO : rdList) {
				resultList.add(reservedDateVO.getReserv_date());
			}
		} 
		else 
		{
			// ReservationVO를 Insert
			int insertedNum = session.insert("insertBooking", reserv);
			resultList.add("TRUE");
			resultList.add(Integer.toBinaryString(insertedNum));
			
			// Insert로 인해 increase 된 reserv_id 값을 가져옴
			int currReservId = session.selectOne("checkReservId");
			
			// 생성된 날짜리스트를 ReservedDate에 등록
			for (String stringDate : dateList) {
				session.insert("insertReservedDate",
						new BookingDateVO(reserv.getAccom_id(), stringDate, currReservId));
			}
		}
		return resultList;
	}

	@Override
	public BookingVO getBookingByReservId(int reserv_Id) {
		return session.selectOne("getBookingByreservId", reserv_Id);
	}
	
	@Override
	public List<BookingVO> getBookingListByUserId(String user_Id) {
		return session.selectList("getBookingListByUserId", user_Id);
	}
	
	@Override
	public List<BookingVO> getBookingListByHostId(String host_Id) {
		return session.selectList("getBookingListByHostId", host_Id);
	}

	@Override
	public int updateBooking(BookingVO reserv) {
		// 기존 예약날짜 리스트 삭제
		session.delete("deleteBookingDateByBookingId", reserv.getReserv_id());
		
		// 새로 업데이트할 예약날짜 리스트 생성
		List<BookingDateVO> reservedDateList = new ArrayList<>();
		List<String> dateStringList = DateMaker.getDateList(reserv.getStart_date(), reserv.getEnd_date());
		for (String stringDate : dateStringList) {
			reservedDateList.add(new BookingDateVO(reserv.getAccom_id(), stringDate, reserv.getReserv_id()));
		}
		
		// 새로운 예약날짜 리스트 insert
		for (BookingDateVO reservedDateVO : reservedDateList) {
			session.insert("insertBookingDate", reservedDateVO);
		}
		
		return session.update("updateBooking", reserv);
	}

	@Override
	public int deleteBookingBybookingId(int reservationId) {
		// 기존 예약날짜 리스트 삭제
		session.delete("deleteBookingDateByBookingId", reservationId);
		return session.update("deleteBookingByBookingId", reservationId);
	}

	@Override
	public int getNotiHostByReservID(int reserv_id) {
		return session.selectOne("getNotiHostByReservID", reserv_id);
	}

	@Override
	public int confirmNotiHostByReservID(int reserv_id) {
		return session.update("confirmNotiHostByReservID", reserv_id);

	}

	@Override
	public int getNotiConfirmedByReservID(int reserv_id) {
		return session.selectOne("getNotiConfirmedByReservID", reserv_id);
	}

	@Override
	public int confirmedNotiConfirmedByReservID(int reserv_id) {
		return session.update("confirmedNotiConfirmedByReservID", reserv_id);

	}

	@Override
	public int deniedNotiConfirmedByReservID(int reserv_id) {
		return session.update("deniedNotiConfirmedByReservID", reserv_id);
	}

	@Override
	public List<BookingVO> getBookingListByAcoomId(int accom_Id) {
		// TODO Auto-generated method stub
		return session.selectList("getBookingListByAccomId",accom_Id);
	}

	

	

}
