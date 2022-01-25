package com.dwav.service;

import java.sql.SQLException;
import java.util.List;

import com.dwav.vo.HomeVO;

public interface HomeService {
	
	public List<HomeVO> getAll();

	/**
	 * 등록건수 
	 * @return
	 * @throws SQLException
	 */
	public int getHomeCount() throws SQLException;
	

	/**
	 * 숙소 등록 
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int InsertHome(HomeVO inVO) throws SQLException;

	/**
	 * 숙소 조회
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public HomeVO SelectHome(HomeVO inVO) throws SQLException;
	
	/**
	 * 지역조회
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public HomeVO locationLike(HomeVO inVO) throws SQLException;
	
	/**
	 * 단건 삭제
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int DeleteHome(HomeVO inVO)throws SQLException;
	
	/**
	 * 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int UpdateHome(HomeVO inVO)throws SQLException;
	
	/**
	 * 목록 조회 
	 * @param inVO
	 * @return List<HomeVO>
	 * @throws SQLException
	 */
	public List<HomeVO> getHomeListBySearchBar(String location, String startDate, String endDate, int numberOfPeople);
    
    
}
