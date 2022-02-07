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

import com.dwav.dao.WishListDao;
import com.dwav.vo.WishListVO;

import com.dwav.vo.SearchVO;


@Repository("WishListDao")
public class WishListDaoImpl implements WishListDao {
		final Logger LOG = LogManager.getLogger(getClass());

	@Inject
	SqlSessionTemplate sqlSessionTemplate;
	
	final String NAMESPACE = "dwav";
	
	@Autowired
	SqlSession session;
	
	public WishListDaoImpl() {}
	
	@Override
	public int doInsertWishList(WishListVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE +".doInsertWishList";
		LOG.debug("==============================");
		LOG.debug("====InsertWishList====");
		LOG.debug("=statement="+statement);
		LOG.debug("=inVO="+inVO);
		LOG.debug("==============================");	
		
		flag = this.sqlSessionTemplate.insert(statement, inVO);
	    LOG.debug("flag:"+flag);
		return flag;
	}
		
	@Override
	public WishListVO doSelectWishList(WishListVO inVO) throws SQLException {
		WishListVO outVO = null;
		String statement = NAMESPACE +".doSelectWishList";
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
	public int dodeleteWishList(WishListVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".dodeleteWishList";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
	}

	/*
	 * @Override public List<WishListVO> doRetrieveWishList(SearchVO inVO) throws
	 * SQLException {
	 * 
	 * String statement = NAMESPACE +".doRetrieveWishList";
	 * LOG.debug("==============================");
	 * LOG.debug("=param="+inVO.toString()); LOG.debug("=statement="+statement);
	 * LOG.debug("==============================");
	 * 
	 * List<WishListVO> list = sqlSessionTemplate.selectList(statement, inVO);
	 * 
	 * for(WishListVO vo :list) { LOG.debug(vo); }
	 * 
	 * return list;
	 * 
	 * }
	 */
	@Override
	public int doupdateWishList(WishListVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".doupdateWishList";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.update(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
		
	}
}
