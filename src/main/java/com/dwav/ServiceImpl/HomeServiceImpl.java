package com.dwav.ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwav.dao.HomeDao;
import com.dwav.service.HomeService;
import com.dwav.vo.HomeVO;



@Service("HomeService")
public class HomeServiceImpl implements HomeService {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	
	@Autowired
	HomeDao homeDao;
	
	
	@Override
	public List<HomeVO> getAll() {
		
		return homeDao.getAll();
	}

	@Override
	public int getHomeCount() throws SQLException {
		
		return homeDao.getHomeCount();
	}


	@Override
	public int InsertHome(HomeVO inVO) throws SQLException {
		
		return homeDao.InsertHome(inVO);
	}

	@Override
	public HomeVO SelectHome(HomeVO inVO) throws SQLException {
		
		return homeDao.SelectHome(inVO);
	}

	@Override
	public HomeVO locationLike(HomeVO inVO) throws SQLException {
		
		return homeDao.locationLike(inVO);
	}

	@Override
	public int DeleteHome(HomeVO inVO) throws SQLException {
		
		return homeDao.DeleteHome(inVO);
	}

	@Override
	public int UpdateHome(HomeVO inVO) throws SQLException {
		
		return homeDao.UpdateHome(inVO);
	}

	@Override
	public List<HomeVO> getHomeListBySearchBar(String location, String startDate, String endDate, int numberOfPeople) {
		
		return homeDao.getHomeListBySearchBar(location, startDate, endDate, numberOfPeople);
	}

}
