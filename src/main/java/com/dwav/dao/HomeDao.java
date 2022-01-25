package com.dwav.dao;

import java.sql.SQLException;
import java.util.List;

import com.dwav.vo.HomeVO;
import com.dwav.vo.SearchVO;




public interface HomeDao {
	
	
	List<HomeVO> getAll();

	/**
	 * 등록건수 
	 * @return
	 * @throws SQLException
	 */
	int getHomeCount() throws SQLException;
	
	/**
	 * 전체 삭제 
	 * @throws SQLException
	 */
	void deleteHomeAll() throws SQLException;

	/**
	 * 숙소 등록 
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int InsertHome(HomeVO inVO) throws SQLException;

	/**
	 * 숙소 조회
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	HomeVO SelectHome(HomeVO inVO) throws SQLException;
	
	/**
	 * 지역조회
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	HomeVO locationLike(HomeVO inVO) throws SQLException;
	
	/**
	 * 단건 삭제
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int DeleteHome(HomeVO inVO)throws SQLException;
	
	/**
	 * 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int UpdateHome(HomeVO inVO)throws SQLException;
	
	/**
	 * 목록 조회 
	 * @param inVO
	 * @return List<HomeVO>
	 * @throws SQLException
	 */
	List<HomeVO>  RetrieveHome(SearchVO inVO)throws SQLException;
	
	
	/**
	 * 지역, 부킹가능날짜, 인원수
	 * @param location
	 * @param startDate
	 * @param endDate
	 * @param numberOfPeople
	 * @return
	 */
	List<HomeVO> getHomeListBySearchBar(String location, String startDate, String endDate, int numberOfPeople);
    
    
}
