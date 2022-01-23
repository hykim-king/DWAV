package com.dwav;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.dwav.cmn.MessageVO;
import com.dwav.dao.UserDao;
import com.dwav.service.UserService;
import com.dwav.vo.UserVO;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class JUserServiceTest {
    final Logger LOG = LogManager.getLogger(getClass());

    @Autowired
    ApplicationContext context;
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserDao    userDao;
	
    @Autowired
    DataSource dataSource;
    
    @Autowired
    PlatformTransactionManager transactionManager;
    
    List<UserVO>   list;
    
	@Before
	public void setUp() throws Exception {
		LOG.debug("===============");
		LOG.debug("setUp()");
		LOG.debug("context:"+context);
		LOG.debug("userService:"+userService);
		LOG.debug("userDao:"+userDao);
		LOG.debug("===============");
		
		list = Arrays.asList(
				new UserVO("physicskdh01","rlaehgud","Kim1","dohyoung","20121123","physicskdh@com1","020-9146-9869","asdasd","asdasd")
				,new UserVO("physicskdh02","rlaehgud","Kim2","dohyoung","20121123","physicskdh@com2","030-9146-9869","asdasd","asdasd")
				,new UserVO("physicskdh03","rlaehgud","Kim3","dohyoung","20121123","physicskdh@com3","010-9146-9869","asdasd","asdasd")
				);
		assertNotNull(userDao);
		assertNotNull(userService);
		assertNotNull(context);
	}

	@Test
	//@Ignore
	public void doLogin() throws SQLException {
		//1. 기존 데이터 삭제
		for(UserVO inVO :list) {
			userDao.doDelete(inVO);
		}
		//2. 신규 데이터 입력(회원가입)
		int flag = userDao.doInsert(list.get(0));
		assertEquals(1, flag);
		//3. 로그인
		
		// 실패 테스트
		UserVO loginVO = list.get(0);

		//아이디가 틀릴 경우
		//loginVO.setuId(loginVO.getuId()+"0000");
		
		//비밀번호가 틀릴 경우
		//loginVO.setPasswd(loginVO.getPasswd()+"23990");
		
		MessageVO msg = userService.doLogin(list.get(0));

		
		//4. 비교
		assertEquals("30", msg.getMsgId());
		
	}

}
