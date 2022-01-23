package com.dwav;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dwav.cmn.MessageVO;
import com.dwav.dao.UserDao;
import com.dwav.vo.SearchVO;
import com.dwav.vo.UserVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class JUserControllerTest {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대역 Mock
	MockMvc  mockMvc;

	UserVO  user01;
    UserVO  user02;
    UserVO  user03;
    UserVO  user04;
    
    SearchVO searchVO;
    
    @Autowired
    UserDao   userDao;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("===============");
		LOG.debug("setUp()");
		LOG.debug("webApplicationContext:"+webApplicationContext);
		LOG.debug("mockMvc:"+mockMvc);
		LOG.debug("===============");
		
		searchVO = new SearchVO("", "", 10, 1);
		
		user01 = new UserVO("physicskdh01","rlaehgud","Kim1","dohyoung","20121123","physicskdh@com1","020-9146-9869","asdasd","asdasd");
		user02 = new UserVO("physicskdh02","rlaehgud","Kim2","dohyoung","20121123","physicskdh@com2","030-9146-9869","asdasd","asdasd");
		user03 = new UserVO("physicskdh03","rlaehgud","Kim3","dohyoung","20121123","physicskdh@com3","010-9146-9869","asdasd","asdasd");
		user04 = new UserVO("physicskdh04","rlaehgud","Kim3","dohyoung","20121123","physicskdh@com4","040-9146-9869","asdasd","asdasd");
		
		//생성
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		assertNotNull(webApplicationContext);
		assertNotNull(mockMvc);
	}
	
	
	
	@Test
	//@Ignore
	public void doLogin() throws Exception{
		// 1. 기존 데이터 삭제
				userDao.deleteAll();

				// 2. 데이터 1건 입력
				add(user01);
				UserVO outVO01 = doSelectOne(user01);
			    isSameUser(outVO01, user01);
			    
				// 3. 로그인(mokmvc로 호출)
				// 호출 URL, param,호출방식
				MockHttpServletRequestBuilder requestBuilder = 
						MockMvcRequestBuilders.post("/user/doLogin.do")
						.param("user_id",user01.getUser_id())
						.param("user_pwd",user01.getUser_pwd())
						;

				ResultActions resultActions = this.mockMvc.perform(requestBuilder)
						.andExpect(status().isOk())
						;
							
				String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString()
						;		
			    
				LOG.debug("===============");
				LOG.debug("result:\n"+result);		
				LOG.debug("===============");
				
				
				
				Gson gson=new Gson();
				MessageVO resultMsg = gson.fromJson(result, MessageVO.class);
				assertEquals("30", resultMsg.getMsgId());
	}

	
	
	//id가 중복되면 flag = 1 -> test 통과 // id가 중복되지 않는 경우, flag = 0, test 실패
	@Test
	//@Ignore
	public void idCheck() throws Exception{
		// 1. 기존 데이터 삭제
		userDao.deleteAll();
		
		// 2. 데이터 1건 입력
		add(user01);
		
		// 3. 비교		
		UserVO outVO01 = doSelectOne(user01);
	    isSameUser(outVO01, user01);		

	    // 4. 호출(단건조회)
	    
	  //호출 URL, param,호출방식
		MockHttpServletRequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get("/user/idCheck.do")
				.param("user_id",user01.getUser_id());
		
		ResultActions resultActions =this.mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				;	
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;		
	    
		LOG.debug("===============");
		LOG.debug("result:\n"+result);		
		LOG.debug("===============");
		
		Gson gson=new Gson();
		MessageVO resultMsg = gson.fromJson(result, MessageVO.class);
		assertEquals("1", resultMsg.getMsgId());

	}
	
	
	
	//삭제,등록,단건조회
		@Test
		//@Ignore
		public void addAndGet() throws Exception {
			LOG.debug("====================");
			LOG.debug("=addAndGet()=");
			LOG.debug("====================");			
			//1. 삭제
			userDao.deleteAll();
			
			//2. 1건 입력
			add(user01);
			assertEquals(1, userDao.getCount());
			add(user02);
			assertEquals(2, userDao.getCount());
			add(user03);
			assertEquals(3, userDao.getCount());
			
			//4.
		    UserVO outVO01 = doSelectOne(user01);
		    isSameUser(outVO01, user01);		
			
		    UserVO outVO02= doSelectOne(user02);
		    isSameUser(outVO02,user02);	    
		    
		    UserVO outVO03= doSelectOne(user03);
		    isSameUser(outVO03,user03);	    
		}
	
		
	@Test
	//@Ignore
	public void  doRetrieve()throws Exception{
		
		userDao.deleteAll();
		
		add(user01);
		add(user02);
		add(user03);
		add(user04);
		
		//searchDiv - 10 : user_id
		searchVO.setSearchDiv("10");
		searchVO.setSearchWord("physicskdh");
		//호출 URL, param,호출방식
		MockHttpServletRequestBuilder requestBuilder= 
				    MockMvcRequestBuilders.get("/user/doRetrieve.do")
				.param("searchDiv", searchVO.getSearchDiv())
				.param("searchWord", searchVO.getSearchWord())
				.param("pageSize", String.valueOf(searchVO.getPageSize()))
				.param("pageNum", String.valueOf(searchVO.getPageNum()))
				;	
		
		ResultActions resultActions =this.mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				;	
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;
		
		LOG.debug("===============");
		LOG.debug("result:\n"+result);		
		LOG.debug("===============");
		
		//JSON String to List<UserVO>
		Gson gson=new Gson();
		List<UserVO> list = 
				gson.fromJson(result, new TypeToken<List<UserVO>>(){}.getType());
		
		assertEquals(list.size(), 4);
		
				
	}
	
	
	public UserVO doSelectOne(UserVO inVO) throws Exception{
		userDao.deleteAll();
		
		userDao.doInsert(inVO);

		
		//호출 URL, param,호출방식
		MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders.get("/user/doSelectOne.do")
				.param("user_id", inVO.getUser_id());
		
		ResultActions resultActions =this.mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				;		
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;		
		
		LOG.debug("===============");
		LOG.debug("result:\n"+result);		
		LOG.debug("===============");
		
		Gson gson=new Gson();
		UserVO outVO = gson.fromJson(result, UserVO.class);
		
		return outVO;
	}
	
	
	
	
	
	
	
	//Birth_date가 오라클에서 날짜 형식으로 내려와서 setUp()에서 기재한 user01의 String birth_date와 같지 않으므로 생기는 문제이다.
	//오라클에서 birth_date를 특정 날짜로 수정하여 오라클에서 다시 확인할 때 내용 변경된 것 확인.
	@Test
	//@Ignore
	public void doUpdate()throws Exception{
		// 1. 전체 삭제
		userDao.deleteAll();
		
		// 2. 1건 입력
		userDao.doInsert(user01);
		assertEquals(1, userDao.getCount());
		
		
		// 3. user01 수정
		String upStr = "_KDH";
		user01.setUser_pwd(user01.getUser_pwd()+upStr);
		user01.setFirst_name(user01.getFirst_name()+upStr);
		user01.setLast_name(user01.getLast_name()+upStr);
		user01.setBirth_date("19940106");
		user01.setEmail(user01.getEmail()+upStr);
		user01.setUser_ph_num(user01.getUser_ph_num()+upStr);
		user01.setUser_img(user01.getUser_img()+upStr);
		user01.setUser_intro(user01.getUser_intro()+upStr);
		

		MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders.post("/user/doUpdate.do")
				.param("user_id",user01.getUser_id())
				.param("user_pwd",user01.getUser_pwd())
				.param("first_name",user01.getFirst_name())
				.param("last_name",user01.getLast_name())
				.param("birth_date",user01.getBirth_date())
				.param("email",user01.getEmail())
				.param("user_ph_num",user01.getUser_ph_num())
				.param("user_img",user01.getUser_img())
				.param("user_intro",user01.getUser_intro())
				;
		
		ResultActions resultActions =this.mockMvc.perform(requestBuilder)
				.andExpect(status().is2xxSuccessful())
				;			
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;				
		
		LOG.debug("===============");
		LOG.debug("result:\n"+result);		
		LOG.debug("===============");			
				
		Gson  gson=new Gson();
		MessageVO resultMsg = gson.fromJson(result, MessageVO.class);
		assertEquals("1", resultMsg.getMsgId());
		
		// 4. 기존 데이터와, 수정된 데이터를 비교
		
//		UserVO vsVO = userDao.doSelectOne(user01);
//		isSameUser(vsVO, user01);
		
	}
	
	
	
	
	
	
//	@Test
//	@Ignore
	public void doDelete(UserVO user01)throws Exception{

		MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders.get("/user/doDelete.do")
				.param("user_id", user01.getUser_id());
		
		ResultActions resultActions =this.mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				;
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;
		LOG.debug("===============");
		LOG.debug("result:\n"+result);		
		LOG.debug("===============");		
		
		//JSON String result
		Gson  gson=new Gson();
		MessageVO resultMsg = gson.fromJson(result, MessageVO.class);
	}
	
//	@Test
//	@Ignore
	public void add(UserVO user02) throws Exception {
		
		MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders.post("/user/add.do")
				.param("user_id",user02.getUser_id())
				.param("user_pwd",user02.getUser_pwd())
				.param("first_name",user02.getFirst_name())
				.param("last_name",user02.getLast_name())
				.param("birth_date",user02.getBirth_date())
				.param("email",user02.getEmail())
				.param("user_ph_num",user02.getUser_ph_num())
				.param("user_img",user02.getUser_img())
				.param("user_intro",user02.getUser_intro())
				;
		
		ResultActions resultActions =this.mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				;		
		
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;		
		LOG.debug("===============");
		LOG.debug("result:\n"+result);		
		LOG.debug("===============");		
				
				
	}

	
	private void isSameUser(UserVO outVO, UserVO userVO) {
		
	    assertEquals(outVO.getUser_id(), userVO.getUser_id());
	    assertEquals(outVO.getFirst_name(),userVO.getFirst_name());
	    assertEquals(outVO.getLast_name(),userVO.getLast_name());
	    assertEquals(outVO.getUser_pwd(),userVO.getUser_pwd());		
	    //assertEquals(outVO.getBirth_date(),userVO.getBirth_date());		
	    assertEquals(outVO.getEmail(),userVO.getEmail());		
	    assertEquals(outVO.getUser_ph_num(),userVO.getUser_ph_num());		
	    assertEquals(outVO.getUser_img(),userVO.getUser_img());		
	    assertEquals(outVO.getUser_intro(),userVO.getUser_intro());		

	}	
}
