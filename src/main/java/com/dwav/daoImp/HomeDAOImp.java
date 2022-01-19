package com.dwav.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwav.dao.HomeDAO;
import com.dwav.vo.HomeVO;

@Repository
public class HomeDAOImp implements HomeDAO {
	final Logger  LOG = LogManager.getFormatterLogger(getClass());
	
	@Autowired
	SqlSession session;
	
	@Autowired
	SqlSessionTemplate  sqlSessionTemplate;
	
	
	
	@Override
	public int insertHome(HomeVO accom_id) {
		return session.insert("insertHome", accom_id);
	}

	@Override
	public int deleteHome(int accom_id) {
		return session.delete("deleteHome", accom_id);
	}						   

	@Override
	public int updateHome(HomeVO accom) {
		return session.update("updateHome", accom);
	}

	@Override
	public HomeVO getHome(int accommodationId) {
		return session.selectOne("getHomeByHostId", accommodationId);
	}


	@Override
	public List<HomeVO> getHomeListBySearchBar(String location, String startDate, String endDate,
			int numberOfPeople) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("location", location);
		parameters.put("startDate", startDate);
		parameters.put("endDate", endDate);
		parameters.put("numPeople", numberOfPeople);
		
		return session.selectList("getHomeListBySearchBar", parameters);
	}
	
	@Override
	public List<HomeVO> getHomeListBySearchBarUsingFilter(String location, String startDate, String endDate,
			int numberOfPeople, int startPrice, int endPrice) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("location", location);
		parameters.put("startDate", startDate);
		parameters.put("endDate", endDate);
		parameters.put("numPeople", numberOfPeople);
		parameters.put("startPrice", startPrice);
		parameters.put("endPrice", endPrice);
		
		return session.selectList("getHomeListBySearchBarUsingPriceFilter", parameters);
	}
	
	

	@Override
	public List<HomeVO> getHomeByHostId(String host_id) {	
		return session.selectList("getHomeByHostId", host_id);
	}

	@Override
	public int checkLastAccomodationId() {
		return session.selectOne("checkAccomId");
	}

	@Override
	public List<HomeVO> getHomeListBySearchBarUsingTypeFilter(String location, String startDate, 
			String endDate, int numberOfPeople, int totChecked) {
		
		return null;
	}

	@Override
	public float getAveragePoint() {
		
		return 0;
	}

	


}
