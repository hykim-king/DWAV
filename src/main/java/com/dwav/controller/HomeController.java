package com.dwav.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dwav.cmn.MessageVO;
import com.dwav.service.HomeService;
import com.dwav.vo.HomeVO;

import com.google.gson.Gson;


@Controller("homeController")
@RequestMapping("home")
public class HomeController {

	final Logger LOG = LogManager.getFormatterLogger(getClass());
	final String VIEW_NAME = "home/home_mng";
	
	@Autowired
	HomeService homeService;
	
	
	public HomeController() {}
	
	//Rest VIEW
	//http://localhost:8080/ehr/home/json_view
	@RequestMapping(value = "/home_view",method = RequestMethod.GET)
	public String jsonView(Model model)throws SQLException{
		
		return "home/home_view";
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


	
	
	@RequestMapping(value ="/UpdateHome.do",method=RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	//??????????????? ????????? ????????? ?????? ??????,HTTP ????????? ?????? body ????????? ????????? ????????????.
	public String UpdateHome(HomeVO inVO)throws SQLException{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");		
		String resultMsg = "";
		
		int flag = homeService.UpdateHome(inVO);
		if(1==flag) {
			resultMsg = inVO.getAccom_Id()+"??? ?????? ???????????????.";
		}else {
			resultMsg = "?????? ??????";
		}			
		
		MessageVO message=new MessageVO(flag+"", resultMsg);
		
		String jsonString = new Gson().toJson(message);
		LOG.debug("=jsonString=\n"+jsonString);
		return jsonString;		
	}
	
	
	
	//http://localhost:8080/ehr/home/doDelete.do
	@RequestMapping(value ="/DeleteHome.do", method= RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
    @ResponseBody	//??????????????? ????????? ????????? ?????? ??????,HTTP ????????? ?????? body ????????? ????????? ????????????.
	public String DeleteHome(HomeVO inVO)throws SQLException{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");
		
		String resultMsg = "";
		
		int flag = homeService.DeleteHome(inVO);
		
		if(1==flag) {
			resultMsg = inVO.getAccom_Id()+"??? ?????? ???????????????.";
		}else {
			resultMsg = "?????? ??????";
		}
		
		MessageVO message=new MessageVO(flag+"", resultMsg);
		
		Gson gson=new Gson();
		
		String jsonString = gson.toJson(message);
		LOG.debug("=jsonString=\n"+jsonString);
		
		return jsonString;
	}

	@RequestMapping(value="/SelectHome.do" ,method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //??????????????? ????????? ????????? ?????? ??????,HTTP ????????? ?????? body ????????? ????????? ????????????.	
	public String SelectHome(HomeVO inVO) throws SQLException{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");	
		
		HomeVO outVO = homeService.SelectHome(inVO);
		LOG.debug("=========================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("=========================");
		
		Gson gson=new Gson();
		String jsonString = gson.toJson(outVO);
		LOG.debug("=========================");
		LOG.debug("=jsonString="+jsonString);
		LOG.debug("=========================");		
		return jsonString;
	} 
	
	@RequestMapping(value = "/InsertHome.do", method = RequestMethod.GET)
    public String insertHome(Model model)throws SQLException{
        LOG.debug("=======================");
        LOG.debug("=insertHome=");
        LOG.debug("=======================");

        return "home/Inserthome";
    }
	
	@RequestMapping(value="/InsertHome.do" ,method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //??????????????? ????????? ????????? ?????? ??????,HTTP ????????? ?????? body ????????? ????????? ????????????.
	public String InsertHome(HomeVO inVO) throws SQLException {
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");		
		String resultMsg = "";
		
		int flag = homeService.InsertHome(inVO);
		
		if(1==flag) {
			resultMsg = inVO.getAccom_Id()+"??? ?????? ???????????????.";
		}else {
			resultMsg = "?????? ??????";
		}		
		
		MessageVO message=new MessageVO(flag+"", resultMsg);
		
		Gson gson=new Gson();
		
		String jsonString = gson.toJson(message);
		LOG.debug("=jsonString=\n"+jsonString);
		
		return jsonString;		
		
	}
	

	
	
}



































