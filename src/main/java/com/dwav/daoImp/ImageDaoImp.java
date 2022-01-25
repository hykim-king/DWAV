package com.dwav.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwav.dao.ImageDao;
import com.dwav.vo.ImageVO;


@Repository
public class ImageDaoImp implements ImageDao {

	 final Logger  LOG = LogManager.getLogger(getClass());

		//sqlSession 객체를 개발자가 직접 생성하지 않고 스프링에서 연결시켜줌
		//의존관계 주입, 마이바티스에서 제공하는 sqlSession클래스에 종속되어있음
		//root-context.xml에서 mybatis 관련 설정 확인
		@Inject
		SqlSessionTemplate  sqlSessionTemplate;
		
		final String NAMESPACE = "mapper.imageMapper";
		
	@Autowired
	SqlSession session;

	

	@Override
	public void deleteImgAll() throws SQLException {
		String statement = NAMESPACE+".deleteImgAll";
    	LOG.debug("==============================");
    	LOG.debug("=======deleteHomeAll========");
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		int flag = this.sqlSessionTemplate.delete(statement);
		LOG.debug("==============================");
		LOG.debug("=flag="+flag);
		LOG.debug("=============================="); 
		
	}

	@Override
	public int InsertImg(ImageVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE +".InsertImg";
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
	public int DeleteImg(ImageVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".DeleteImg";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
	}

	@Override
	public ImageVO SelectImg(ImageVO inVO) throws SQLException {
		ImageVO outVO = null;
		String statement = NAMESPACE +".SelectImg";
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




	

}
