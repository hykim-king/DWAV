package com.dwav.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dwav.cmn.MessageVO;
import com.dwav.service.ImageService;
import com.dwav.vo.HomeVO;
import com.dwav.vo.ImageVO;

import com.google.gson.Gson;



@Controller("ImageController")
@RequestMapping("image")
public class ImageController {

	final Logger LOG = LogManager.getFormatterLogger(getClass());
	final String VIEW_NAME = "image/image_mng";
	
	@Autowired
	ImageService imageService;
	
	ImageController(){}
	
	
	@RequestMapping(value = "/json_view",method = RequestMethod.GET)
	public String jsonView(Model model)throws SQLException{
		
		return "json/json_view";
	}
	
	@RequestMapping(value ="/DeleteHome.do", method= RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
    @ResponseBody	//스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String DeleteImg(ImageVO inVO)throws SQLException{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");
		
		String resultMsg = "";
		
		int flag = imageService.DeleteImg(inVO);
		
		if(1==flag) {
			resultMsg = inVO.getImage_id()+"가 삭제 되었습니다.";
		}else {
			resultMsg = "삭제 실패";
		}
		
		MessageVO message=new MessageVO(flag+"", resultMsg);
		
		Gson gson=new Gson();
		
		String jsonString = gson.toJson(message);
		LOG.debug("=jsonString=\n"+jsonString);
		
		return jsonString;
	}

	@RequestMapping(value="/SelectHome.do" ,method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.	
	public String SelectImg(ImageVO inVO) throws SQLException{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");	
		
		ImageVO outVO = imageService.SelectImg(inVO);
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
	
	
	@RequestMapping(value="/InsertHome.do" ,method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String InsertHome(ImageVO inVO) throws SQLException {
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");		
		String resultMsg = "";
		
		int flag = imageService.InsertImg(inVO);
		
		if(1==flag) {
			resultMsg = inVO.getImage_id()+"가 등록 되었습니다.";
		}else {
			resultMsg = "등록 실패";
		}		
		
		MessageVO message=new MessageVO(flag+"", resultMsg);
		
		Gson gson=new Gson();
		
		String jsonString = gson.toJson(message);
		LOG.debug("=jsonString=\n"+jsonString);
		
		return jsonString;		
		
	}
	
	
}
