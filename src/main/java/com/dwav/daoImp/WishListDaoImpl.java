package com.pcwk.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.domain.WishListVO;
import com.sun.mail.imap.protocol.Namespaces.Namespace;

@Repository
public class WishListDaoImpl implements WishListDao {
		final Logger LOG = LogManager.getLogger(getClass());

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	final String NAMESPACE = "com.pcwk.domain.";
	
	public WishListDaoImpl() {}
	
	
	public List<WishListVO> listIdx(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".listIdx";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	public List<WishListVO> homeImg(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".homeImg";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	public List<WishListVO> checkIn(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".checkIn";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	public List<WishListVO> checkOut(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".checkOut";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	public List<WishListVO> homeType(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".homeType";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	public List<WishListVO> homeFacility(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".homeFacility";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	public List<WishListVO> homeRule(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".homeRule";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	public List<WishListVO> homeIdx(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".homeIdx";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	public List<WishListVO> userId(WishListVO inVO) throws SQLException {
		String statement = NAMESPACE +".userId";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		List<WishListVO> list =  sqlSessionTemplate.selectList(statement, inVO);
		
		for(WishListVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

}