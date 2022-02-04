package com.dwav.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dwav.cmn.MessageVO;
import com.dwav.cmn.StringUtil;
import com.dwav.dao.FacilitiesDAO;
import com.dwav.vo.FacilitiesVO;
import com.dwav.vo.SearchVO;
import com.dwav.vo.UserVO;
import com.google.gson.Gson;


@Controller("facilitiesController")
@RequestMapping("facilities")
public class FacilitiesController {
	
	final Logger LOG = LogManager.getFormatterLogger(getClass());

	@Autowired
	FacilitiesDAO facilitiesDAO;
	
	public FacilitiesController() {}
	
	
	@RequestMapping(value = "/facil_view.do", method = RequestMethod.GET)
	public String facilView(Model model, SearchVO inVO)throws SQLException{
		
		if(0==inVO.getPageSize()) {
			inVO.setPageSize(10);
			
		}
		if(0==inVO.getPageNum()) {
			inVO.setPageNum(1);
			
		}
		
		// 검색 구분자, 10 : user_id, 20 : first_name, 30 : last_name, 40 : birth_date, 50 : email, 60 : user_ph_num, 70 : join_date
		if(null == inVO.getSearchDiv()) {
			inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
		}
		if(null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchDiv()));
		}
		
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");	
		
		List<FacilitiesVO> list = facilitiesDAO.doRetrieveAmen(inVO);
		
		double totalCnt = 0;
		if(list != null && list.size()>0) {
			totalCnt =Math.ceil(list.get(0).getTotalCnt()/(inVO.getPageSize()*1.0));
		}
		model.addAttribute("totalCnt",totalCnt);// 총 글 수
		model.addAttribute("list",list);// 총 글 수
		return "facility/facil_mng";
		
	}

	@RequestMapping(value = "/facil_reg.do", method = RequestMethod.GET)
	public String facilReg(Model model, SearchVO inVO)throws SQLException{
		LOG.debug("=======================");
		LOG.debug("=facilReg=");
		LOG.debug("=======================");	
		
		return "facility/facil_reg";
	}
	
	
	
	/**
	 * 목록 조회
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/doRetrieveAmen.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String doRetrieveAmen(SearchVO inVO) throws SQLException {
		
		if(0==inVO.getPageSize()) {
			inVO.setPageSize(10);
		}
		
		if(0==inVO.getPageNum()) {
			inVO.setPageNum(1);
		}
		
		inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
		inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord()));
		
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");	
		List<FacilitiesVO> list = this.facilitiesDAO.doRetrieveAmen(inVO);
		
		return new Gson().toJson(list);
		
	}

	/**
	 * 편의시설 추가
	 * @param inVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doInsertAmen.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String doInsertAmen(FacilitiesVO inVO) throws Exception{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");	
		String resultMsg= "";
		
		int flag = facilitiesDAO.doInsertAmen(inVO);
		
		if(1==flag) {
			resultMsg = inVO.getAccom_id()+"번 숙소의"+ inVO.getAmenity_val()+"편의시설이 등록 되었습니다.";
		}else {
			resultMsg = "등록 실패";
		}
		MessageVO message=new MessageVO(flag+"", resultMsg);
		String jsonString = new Gson().toJson(message);
		LOG.debug("=jsonString=\n"+jsonString);
		
		return jsonString;
		
	}

	/**
	 * 단건 삭제
	 * @param inVO
	 * @return 삭제 건수 : 1(1개가 지워졌다)/0(지워지지 않았다)
	 * @throws SQLException
	 */
	@RequestMapping(value = "/doDeleteAmen.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String doDeleteAmen(FacilitiesVO inVO) throws SQLException{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");	
		
		String resultMsg= "";
		
		int flag = facilitiesDAO.doDeleteAmen(inVO);
		
		if(1==flag) {
			resultMsg = "삭제 되었습니다.";
		}else {
			resultMsg = "삭제 실패";
		}	
		MessageVO message=new MessageVO(flag+"", resultMsg);
		String jsonString = new Gson().toJson(message);
		LOG.debug("=========================");
		LOG.debug("=message="+message);
		LOG.debug("=========================");	
		LOG.debug("=jsonString=\n"+jsonString);
		
		return jsonString;
		
	}
	
}
