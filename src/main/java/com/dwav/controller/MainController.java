/**
 * package: com.pcwk.ehr.main.controller
 * file name: MainController.java
 * description: main
 * user: HKEDU
 * create date: 2022-01-20
 * version: 0.5
 * Copyright (c) by PCWK All right reserved.
 * Modification Information
 * 수정일   수정자    수정내용
 *-----------------------------------------------------
 * 2022-01-20 최초생성
 *-----------------------------------------------------
 */
package com.dwav.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dwav.service.HomeService;
import com.dwav.vo.HomeVO;

/**
 * @author HKEDU
 *
 */
@Controller
@RequestMapping("main")
public class MainController {
	final Logger LOG = LogManager.getFormatterLogger(getClass());
	final String VIEW_NAME = "home/home_mng";
	
	@Autowired
	HomeService homeService;
	
	public MainController() {}
	//http://localhost:8080/dwav/main/main_view.do
	@RequestMapping(value = "/main_view.do",method = RequestMethod.GET)
	public String mainView()throws SQLException{
		LOG.debug("======================");
		LOG.debug("=mainView=");
		LOG.debug("======================");			
		return "main/main";
	}
	
	@RequestMapping(value = "searchInList.do" )
	@ResponseBody
	public List<HomeVO> searchList(@RequestParam String city,@RequestParam String startDate,@RequestParam String endDate,@RequestParam String person) {
		LOG.debug(city+" "+startDate+" "+endDate+" "+person);
		int p = Integer.parseInt(person);
		
		List<HomeVO>acvo = homeService.getHomeListBySearchBar(city, startDate, endDate, p);
		LOG.debug(acvo.size());
		LOG.debug(acvo.toString());		
		return acvo;
	}
	
	@RequestMapping(value = "searchInListFromMain.do", method=RequestMethod.POST )
	public ModelAndView searchFromMain(@RequestParam String city,@RequestParam String startDate,@RequestParam String endDate,@RequestParam String person) {
		LOG.debug(city+" "+startDate+" "+endDate+" "+person);
		int p = Integer.parseInt(person);
		
		List<HomeVO>acvo = homeService.getHomeListBySearchBar(city, startDate, endDate, p);
		LOG.debug(acvo.size());
		LOG.debug(acvo.toString());		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchList");
		mv.addObject("voSize", acvo.size());	
		mv.addObject("city", city);
		mv.addObject("startDate", startDate);
		mv.addObject("endDate", endDate);
		mv.addObject("person", person);
		mv.addObject("acvo",acvo);
		
		
		return mv;
	}
	
	
	
}
