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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author HKEDU
 *
 */
@Controller
@RequestMapping("main")
public class MainController {
	final Logger LOG = LogManager.getFormatterLogger(getClass());
	
	public MainController() {}
	//http://localhost:8080/ehr/main/login_view.do
	@RequestMapping(value = "/main_view.do",method = RequestMethod.GET)
	public String mainView()throws SQLException{
		LOG.debug("======================");
		LOG.debug("=mainView=");
		LOG.debug("======================");			
		return "main/main";
	}

	
}
