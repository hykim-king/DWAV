package com.dwav.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dwav.vo.SearchVO;
import com.dwav.vo.UserVO;






public interface UserDao {
	
	/**
	 * 비밀번호 check
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	int pwCheck(UserVO inVO) throws SQLException;
	
	/**
	 * 1. 로그인 시, 통과 되어야 로그인 됨.
	 * 
	 * 2. 중복 체크 시 조회가 되면 중복이 된다는 뜻임! 즉, 테스트가 통과되면 중복, 테스트에서 assertion 오류나면 중복 아님
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	int idCheck(UserVO inVO) throws SQLException;
	
	/**
	 * 전체 회원 조회
	 * @return
	 */
	List<UserVO> getAll();

	/**
	 * 총 회원 수 
	 * @return
	 * @throws SQLException
	 */
	int getCount() throws SQLException;

	/**
	 * 전체 삭제 
	 * @throws SQLException
	 */
	void deleteAll() throws SQLException;

	/**
	 * 회원 가입
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doInsert(UserVO inVO) throws SQLException;

	/**
	 * 회원 조회
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	UserVO doSelectOne(UserVO inVO) throws SQLException;
	
	/**
	 * 회원 탈퇴
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doDelete(UserVO inVO)throws SQLException;
	
	/**
	 * 회원 정보 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doUpdate(UserVO inVO)throws SQLException;
	
	
	/**
	 * 유저 검색 조회 
	 * @param inVO
	 * @return List<UserVO>
	 * @throws SQLException
	 */
    List<UserVO>  doRetrieve(SearchVO inVO) throws SQLException;
    
    
    
}