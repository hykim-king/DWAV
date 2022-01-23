/**
 * 
 */
package com.dwav.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import com.dwav.cmn.MessageVO;
import com.dwav.dao.UserDao;
import com.dwav.vo.SearchVO;
import com.dwav.vo.UserVO;



/**
 * @author Dosn
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
    UserDao userDao;
	
	@Autowired
	@Qualifier("mailSender")
	MailSender mailSender;
	
	public UserServiceImpl() {}
	
	
	
	@Override
	public MessageVO doLogin(UserVO inVO) throws SQLException {
	
		MessageVO message = new MessageVO();
		int flag;
	
		// 1. ID 확인: 이상 있을 시 10
		flag = userDao.idCheck(inVO);
		if(1 != flag) {
			message.setMsgId("10");
			message.setMsgContents("아이디를 확인 하세요.");
			
			return message;
		}
		
		// 2. PASSWD 체크: 이상 있을 시 20
		
		flag = userDao.pwCheck(inVO);
		if(1 != flag) {
			message.setMsgId("20");
			message.setMsgContents("비밀번호를 확인 하세요.");
			
			return message;
		}
		
		// 3. 메세지 보내기: 둘다 정상이면 30
		message.setMsgId("30");
		message.setMsgContents("아이디, 비밀번호가 확인되었습니다.");
		
		return message;
	}

	@Override
	public int idCheck(UserVO inVO) throws SQLException {

		return userDao.idCheck(inVO);
	}

	@Override
	public UserVO doSelectOne(UserVO inVO) throws SQLException {

		return userDao.doSelectOne(inVO);
	}

	@Override
	public int doDelete(UserVO inVO) throws SQLException {

		return userDao.doDelete(inVO);
	}

	@Override
	public int doUpdate(UserVO inVO) throws SQLException {

		return userDao.doUpdate(inVO);
	}

	@Override
	public List<UserVO> doRetrieve(SearchVO inVO) throws SQLException {

		return userDao.doRetrieve(inVO);
	}



	@Override
	public int add(UserVO inVO) throws SQLException {

		return userDao.doInsert(inVO);
	}

}
