package com.dwav.daoImp;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.dwav.dao.ReviewDao;
import com.dwav.vo.ImageVO;
import com.dwav.vo.ReviewVO;
import com.dwav.vo.SearchVO;
import com.dwav.vo.UserVO;

public class ReviewDaoImpl implements ReviewDao {
	
	 final Logger  LOG = LogManager.getLogger(getClass());
	 
	 @Inject
	 SqlSessionTemplate  sqlSessionTemplate;
		
		final String NAMESPACE = "mapper.imageMapper";
		
		@Autowired
		SqlSession session;
	 
	@Override
	public int doInsert(ReviewVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE +".doInsertReview";
		LOG.debug("==============================");
		LOG.debug("====InsertHome====");
		LOG.debug("=statement="+statement);
		LOG.debug("=inVO="+inVO);
		LOG.debug("==============================");	
		
		flag = this.sqlSessionTemplate.insert(statement, inVO);
	    LOG.debug("flag:"+flag);
		return flag;
	}

	@Override
	public ReviewVO doSelectOne(ReviewVO inVO) throws SQLException {
		ReviewVO outVO = null;
		String statement = NAMESPACE +".doSelectReview";
		LOG.debug("==============================");
		LOG.debug("=========SelectHome===========");
		LOG.debug("=inVO="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		
		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("==============================");
		LOG.debug("=outVO="+outVO.toString());
		LOG.debug("==============================");	
		return outVO;		
	}

	@Override
	public int doDelete(ReviewVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".dodeleteReview";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
	}

	@Override
	public int doUpdate(ReviewVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".doupdateReview";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.update(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
	}

	@Override
	public List<ReviewVO> doRetrieve(SearchVO inVO) throws SQLException {
		
		String statement = NAMESPACE +".doRetrieveReview";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		List<ReviewVO> list = sqlSessionTemplate.selectList(statement, inVO);
		
		for(ReviewVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
		
	}

}
