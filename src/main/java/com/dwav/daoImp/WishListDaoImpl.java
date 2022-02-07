package com.dwav.daoImp;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.dwav.dao.WishListDao;
import com.dwav.vo.ReviewVO;
import com.dwav.vo.SearchVO;
import com.dwav.vo.WishListVO;

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


	@Override
	public void dodeleteWishList(WishListVO wishList01) {
		
		
	}

	


	@Override
	public List<ReviewVO> doRetrieveReview(SearchVO searchVO) {
		
		return null;
	}


	@Override
	public int doInsertWishList(WishListVO wishList01) {
		// TODO Auto-generated method stub
		return 0;
	}

}
