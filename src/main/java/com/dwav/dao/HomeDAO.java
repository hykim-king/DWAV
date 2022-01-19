package com.dwav.dao;

import java.util.List;

import com.dwav.vo.HomeVO;

public interface HomeDAO {
	// CRUDs
	public int insertHome(HomeVO accom);
	public int deleteHome(int accommodationId);
	public int updateHome(HomeVO accom);
	public HomeVO getHome(int accommodationId);
	// public List<HomeVO> getHomeListByLocation(String location);
	
	// Functional Methods
	public float getAveragePoint();
	public List<HomeVO> getHomeListBySearchBar(String location, String startDate, String endDate, int numberOfPeople);

	public List<HomeVO> getHomeListBySearchBarUsingFilter(String location, String startDate, String endDate,
			int numberOfPeople, int startPrice, int endPrice);
	public List<HomeVO> getHomeListBySearchBarUsingTypeFilter(String location, String startDate,
			String endDate, int numberOfPeople, int totChecked);

	public List<HomeVO> getHomeByHostId(String host_id);
	public int checkLastAccomodationId();

}
