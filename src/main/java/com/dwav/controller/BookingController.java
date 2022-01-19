package com.dwav.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dwav.dao.BookingDAO;
import com.dwav.dao.HomeDAO;
import com.dwav.dao.ImageDAO;
import com.dwav.vo.BookingVO;
import com.dwav.vo.HomeVO;
import com.dwav.vo.ImageVO;


@Controller("BookingController")
public class BookingController {
	
	@Autowired
	BookingDAO bookingDAO;
	
	@Autowired
	HomeDAO homeDAO;
	
	@Autowired
	ImageDAO imageDAO;
	
	

	@RequestMapping(value="getReservList.do", method=RequestMethod.GET )
	public ModelAndView getBookingList(@RequestParam String userId){
		List<BookingVO> reservValues = bookingDAO.getBookingListByUserId(userId);
		List<HomeVO> accomValues = new ArrayList<HomeVO>();
		List<ImageVO> imageValues = new ArrayList<ImageVO>();
		
		for(int i=0; i<reservValues.size(); i++){
			accomValues.add(i,homeDAO.getHome(reservValues.get(i).getAccom_id()));
//			imageValues.add(i,imageDAO.getImageByAccomId(reservValues.get(i).getAccom_id()));
			//dao, mapper로 이미지 한개만 가져오게 만듬(rownum<=1)
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("BookingList");
		view.addObject("Bookings", reservValues);
		view.addObject("accommodations", accomValues);
		view.addObject("images", imageValues);

//		Map<String, Object> dataMap = new HashMap<>();
//		dataMap.put("Bookings", (List<BookingVO>)reservValues);
//		dataMap.put("accommodations", (List<AccommodationVO>)accomValues);
//		dataMap.put("images", (List<ImageVO>)imageValues);
		
		return view;

		
	/*	*/
		
	}
	
	@RequestMapping(value="getReservUpdateForm.do", method=RequestMethod.GET )
	public ModelAndView getBookingUpdateForm(@RequestParam String reserv_id){
		int tmp = Integer.parseInt(reserv_id);
		BookingVO reservVO  = bookingDAO.getBookingByReservId(tmp);
		HomeVO accomVO = homeDAO.getHome(reservVO.getAccom_id());
		ImageVO imageVO = new ImageVO();
//		ImageVO imageVO = imageDAO.getImageByAccomId(reservVO.getAccom_id());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("updateBooking");
		view.addObject("Booking", reservVO);
		view.addObject("Home", accomVO);
		view.addObject("image", imageVO);
		
		return view;
		
	}

	@RequestMapping(value="UpdateReserv.do", method=RequestMethod.POST )
	public String updateBooking(@ModelAttribute BookingVO reserv,HttpSession session){
		String userID = (String)session.getAttribute("userid");
		
		BookingVO originVO = bookingDAO.getBookingByReservId(reserv.getReserv_id());
		HomeVO accomVO = homeDAO.getHome(originVO.getAccom_id());
		float price = (accomVO.getPrice() * reserv.getNumber_of_people());
			
		BookingVO updateVO = new BookingVO(originVO.getAccom_id(), reserv.getEnd_date(), reserv.getNumber_of_people(), reserv.getStart_date(), originVO.getUser_id(), price, originVO.getHost_id());
		updateVO.setReserv_id(reserv.getReserv_id());
		int cnt = bookingDAO.updateBooking(updateVO);
		if(cnt == 1)
			return "redirect:/getReservList.do?userId="+userID;
		else return "";
	}
	
	
	@RequestMapping(value="DeleteReserv.do", method=RequestMethod.GET )
	public String DeleteBooking(@RequestParam String reserv_id,HttpSession session){
		String userID = (String)session.getAttribute("userid");
		
		int tmp = Integer.parseInt(reserv_id);
		int cnt = bookingDAO.deleteBookingBybookingId(tmp);
		
		if(cnt == 1)
			return "redirect:/getReservList.do?userId="+userID;
		else return "";
		
	}
	
}
