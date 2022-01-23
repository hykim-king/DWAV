package com.dwav.service;

import java.sql.SQLException;
import java.util.List;

import com.dwav.cmn.MessageVO;
import com.dwav.vo.SearchVO;
import com.dwav.vo.UserVO;


public interface UserService {
	
	/**
	 * 로그인 기능
	 * @param inVO
	 * @return MessageVO
	 * @throws SQLException
	 */
	public MessageVO doLogin(UserVO inVO) throws SQLException;
	
	
	/**
	 * 1. 회원가입 시 아이디 중복 체크 --> 결과값이 0이 나와야 넘어갈 수 잇음
	 * 
	 * 2. 로그인 시 --> 결과값이 1이 나와야 넘어갈 수 있다.
	 * @param inVO
	 * @return 1(ID 존재) or 0(ID 없음)
	 * @throws SQLException
	 */
	public int idCheck(UserVO inVO) throws SQLException;
	
	/**
	 * 단건 사용자 조회
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserVO doSelectOne(UserVO inVO) throws SQLException;
	
	/**
	 * 단건 삭제
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(UserVO inVO)throws SQLException;	
	
	/**
	 * 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(UserVO inVO)throws SQLException;
	
	
	/**
	 * 목록 조회(검색) 
	 * @param inVO
	 * @return List<UserVO>
	 * @throws SQLException
	 */
    List<UserVO>  doRetrieve(SearchVO inVO)throws SQLException;
    
	/**
	 * 회원가입
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int add(UserVO inVO) throws SQLException;
	
}
