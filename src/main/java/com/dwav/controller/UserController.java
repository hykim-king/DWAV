package com.dwav.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dwav.cmn.MessageVO;
import com.dwav.cmn.StringUtil;
import com.dwav.service.UserService;
import com.dwav.vo.SearchVO;
import com.dwav.vo.UserVO;
import com.google.gson.Gson;


@Controller("userController")
@RequestMapping("user")
public class UserController {
	final Logger LOG = LogManager.getFormatterLogger(getClass());
	final String VIEW_NAME = "user/user_mng";

	@Autowired
	UserService userService;

	public UserController() {
	}

	// HttpSession이 파라미터에 추가되는것 : 세션을 굽는다!
	// method = RequestMethod.POST : get방식의 경우 url에 넘기는 값이 노출되므로
	@RequestMapping(value = "/doLogin.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doLogin(UserVO inVO, HttpSession session) throws SQLException{
		LOG.debug("=================================");
		LOG.debug("=doLogin()=");
		LOG.debug("==inVO="+inVO);
		LOG.debug("=================================");
		
		MessageVO message = new MessageVO();
		Gson gson = new Gson();
		
		// id null check
		if(null == inVO.getUser_id() || inVO.getUser_id().equals("")) {
			LOG.debug("=IllegalArgumentException="+inVO.getUser_id());
			
			message.setMsgId("40");
			message.setMsgContents("아이디는 필수 입력 사항입니다.");
			
			return gson.toJson(message);
		}
		
		message = userService.doLogin(inVO);
		
		//30번이면 Session처리
		if("30".equals(message.getMsgId())) {
			UserVO loginUser = userService.doSelectOne(inVO);
			if(null != loginUser) {
				message.setMsgContents(loginUser.getFirst_name()+loginUser.getLast_name()+"님이 로그인 되었습니다.");
			}
			
			session.setAttribute("user", loginUser);
		}
		
		
		String jsonString = gson.toJson(message);
		LOG.debug("=================================");
		LOG.debug("==jsonString="+jsonString);
		LOG.debug("=================================");
		
		return jsonString;
	}
		
	

	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String idCheck(UserVO inVO) throws SQLException {
		LOG.debug("======================");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("======================");
		String resultMsg = "";

		int flag = userService.idCheck(inVO);
		if (1 == flag) {
			resultMsg = inVO.getUser_id() + "가 존재 합니다.";
		} else {
			resultMsg = inVO.getUser_id() + "는 사용할 수 있습니다.";
		}

		MessageVO message = new MessageVO(flag + "", resultMsg);

		String jsonString = new Gson().toJson(message);
		LOG.debug("=jsonString=" + jsonString);

		return jsonString;
	}
	
	

	@RequestMapping(value = "/doRetrieve.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(SearchVO inVO) throws SQLException {

		String jsonString = "";

		// pageSize==10
		if (0 == inVO.getPageSize()) {
			inVO.setPageSize(10);
		}

		// pageNum==1
		if (0 == inVO.getPageNum()) {
			inVO.setPageNum(1);
		}

		// 검색구분
		if (null == inVO.getSearchDiv()) {
			inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
		}

		// 검색어
		if (null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord()));
		}

		LOG.debug("=========================");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=========================");

		List<UserVO> list = this.userService.doRetrieve(inVO);
		Gson gson = new Gson();
		jsonString = gson.toJson(list);
		LOG.debug("=========================");
		LOG.debug("=jsonString=\n" + jsonString);
		LOG.debug("=========================");
		return jsonString;
	}

	@RequestMapping(value = "/doSelectOne.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody // 스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String doSelectOne(UserVO inVO) throws SQLException {
		LOG.debug("=========================");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=========================");

		UserVO outVO = userService.doSelectOne(inVO);
		LOG.debug("=========================");
		LOG.debug("=outVO=" + outVO);
		LOG.debug("=========================");

		Gson gson = new Gson();
		String jsonString = gson.toJson(outVO);
		LOG.debug("=========================");
		LOG.debug("=jsonString=" + jsonString);
		LOG.debug("=========================");
		return jsonString;
	}

	// http://localhost:8080/ehr/user/doDelete.do
	@RequestMapping(value = "/doUpdate.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody // 스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String doUpdate(UserVO inVO) throws SQLException {
		LOG.debug("=========================");
		LOG.debug("=doUpdate()=");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=========================");

		String resultMsg = "";

		// flag = 1 : 성공 0 : 실패
		int flag = userService.doUpdate(inVO);
		if (flag == 1) {
			resultMsg = inVO.getUser_id() + "아이디의 정보가 수정되었습니다.";
		} else {
			resultMsg = "수정 실패";
		}

		MessageVO message = new MessageVO(flag + "", resultMsg);

		Gson gson = new Gson();
		String jsonString = gson.toJson(message);
		LOG.debug("=jsonString=\n" + jsonString);

		return jsonString;
	}

	// http://localhost:8080/ehr/user/doDelete.do
	@RequestMapping(value = "/doDelete.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody // 스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String doDelete(UserVO inVO) throws SQLException {
		LOG.debug("=========================");
		LOG.debug("=doDelete()=");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=========================");

		String resultMsg = "";

		// flag = 1 : 성공 0 : 실패
		int flag = userService.doDelete(inVO);

		if (1 == flag) {
			resultMsg = inVO.getUser_id() + "아이디가 삭제 되었습니다.";
		} else {
			resultMsg = "삭제 실패";
		}

		MessageVO message = new MessageVO(flag + "", resultMsg);

		Gson gson = new Gson();
		String jsonString = gson.toJson(message);
		LOG.debug("=jsonString=\n" + jsonString);

		return jsonString;

	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody // 스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String add(UserVO inVO) throws SQLException {
		LOG.debug("=========================");
		LOG.debug("=add()=");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=========================");
		String resultMsg = "";

		int flag = userService.add(inVO);

		if (flag == 1) {
			resultMsg = inVO.getUser_id() + "아이디가 등록되었습니다.";
		} else {
			resultMsg = "아이디 등록에 실패하였습니다.";
		}

		MessageVO message = new MessageVO(flag + "", resultMsg);

		String jsonString = new Gson().toJson(message);
		LOG.debug("=jsonString=\n" + jsonString);

		return jsonString;
	}

}
