package com.dwav.daoImp;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwav.dao.ReviewDao;
import com.dwav.vo.ReviewVO;
import com.dwav.vo.SearchVO;

@Repository("reviewDao") // 서버가 시작될 때, 객체를 만들지 않고도 이 클래스는 자동으로 메모리에 등록됨
public class ReviewDaoImpl implements ReviewDao {
	
	 final Logger  LOG = LogManager.getLogger(getClass());
	 
	 @Inject
	 SqlSessionTemplate  sqlSessionTemplate;
		
	final String NAMESPACE = "dwav";
		
	@Autowired
	SqlSession session;
	
	
	public ReviewDaoImpl() {}
	 
	 /**
	  * 성공 여부 성공 : 1, 실패 : 0
	  */
	@Override
	public int doInsertReview(ReviewVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE +".doInsertReview";
		LOG.debug("==============================");
		LOG.debug("====InsertReview====");
		LOG.debug("=statement="+statement);
		LOG.debug("=inVO="+inVO);
		LOG.debug("==============================");	
		
		flag = this.sqlSessionTemplate.insert(statement, inVO);
	    LOG.debug("flag:"+flag);
		return flag;
	}

	@Override
	public ReviewVO doSelectReview(ReviewVO inVO) throws SQLException {
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
	public int dodeleteReview(ReviewVO inVO) throws SQLException {
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
	public int doupdateReview(ReviewVO inVO) throws SQLException {
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
	public List<ReviewVO> doRetrieveReview(SearchVO inVO) throws SQLException {
		
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
