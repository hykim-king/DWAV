package com.dwav;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
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
import com.dwav.dao.FacilitiesDAO;
import com.dwav.vo.FacilitiesVO;
import com.dwav.vo.SearchVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class JFacilitiesControllerTest {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	FacilitiesDAO dao;
	
	//브라우저 대역 Mock
	MockMvc  mockMvc;
	FacilitiesVO facil01;
	FacilitiesVO facil02;
	FacilitiesVO facil03;
	FacilitiesVO facil04;
	
	SearchVO search;

	
	@Before
	public void setUp() throws Exception {
		
		
		facil01 = new FacilitiesVO(1,1, "수영장", "수영장1");
		facil02 = new FacilitiesVO(2,1, "수영장", "수영장2");
		facil03 = new FacilitiesVO(3,1, "수영장", "수영장3");
		facil04 = new FacilitiesVO(4,1, "안마의자", "바디프렌즈");
		
		search = new SearchVO();

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		assertNotNull(webApplicationContext);
		assertNotNull(dao);
		
	}

	
	public void isSameAmen(FacilitiesVO outVO, FacilitiesVO facilVO) {

		assertEquals(outVO.getAccom_id(), facilVO.getAccom_id());
		assertEquals(outVO.getAmen_id(), facilVO.getAmen_id());
		assertEquals(outVO.getAmenity_type(), facilVO.getAmenity_type());
		assertEquals(outVO.getAmenity_val(), facilVO.getAmenity_val());
	}
	
	/**
	 * 검색 조회
	 * @throws Exception
	 */
	@Test
	//@Ignore
	public void doRetrieveAmen() throws Exception{
		
		dao.deleteAllAmen();
		dao.doInsertAmen(facil01);
		dao.doInsertAmen(facil02);
		dao.doInsertAmen(facil03);
		
		MockHttpServletRequestBuilder requestBuilder =
				MockMvcRequestBuilders.get("/facilities/doRetrieveAmen.do")
				.param("searchDiv", search.getSearchDiv())
				.param("searchWord", search.getSearchWord())
				.param("pageSize", search.getPageSize() + "")
				.param("pageNum", search.getPageNum() + "")
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
		
		Gson gson = new Gson();
		List<FacilitiesVO> list = 
				gson.fromJson(result, new TypeToken<List<FacilitiesVO>>(){}.getType());
		
		assertEquals(list.size(), 3);
	}

	
	/**
	 * 단건 입력
	 * @throws Exception
	 */
	@Test
	//@Ignore
	public void doInsertAmen() throws Exception{
		//호출 URL, param,호출방식
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/facilities/doInsertAmen.do")
				.param("amen_id", facil04.getAmen_id() + "")
				.param("accom_id", facil04.getAccom_id() + "")
				.param("amenity_type", facil04.getAmenity_type())
				.param("amenity_val", facil04.getAmenity_val())
				;

		ResultActions resultActions = this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
		String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();

		LOG.debug("===============");
		LOG.debug("result:\n" + result);
		LOG.debug("===============");
	}

	
	/**
	 * 단건 삭제
	 * @param inVO
	 * @return 삭제 건수 : 1(1개가 지워졌다)/0(지워지지 않았다)
	 * @throws Exception 
	 */
	@Test
	//@Ignore
	public void doDeleteAmen() throws Exception{

		// 호출 URL, param,호출방식
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/facilities/doDeleteAmen.do")
				.param("amen_id", facil01.getAmen_id() + "");

		ResultActions resultActions = this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;
		
		LOG.debug("===============");
		LOG.debug("result:\n"+result);		
		LOG.debug("===============");
		
		//Json String result
		Gson gson=new Gson();
		MessageVO resultMsg = gson.fromJson(result, MessageVO.class);
		LOG.debug("===============");
		LOG.debug("resultMsg:\n"+resultMsg);		
		LOG.debug("===============");
		
//		assertEquals("1",resultMsg.getMsgId());
		
	}
	
	
}
