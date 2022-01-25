package com.dwav.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.dwav.dao.HomeDao;
import com.dwav.vo.HomeVO;
import com.dwav.vo.SearchVO;

@Repository("HomeDao")
public class HomeDaoImple implements HomeDao {
	
	 final Logger  LOG = LogManager.getLogger(getClass());

	//sqlSession 객체를 개발자가 직접 생성하지 않고 스프링에서 연결시켜줌
	//의존관계 주입, 마이바티스에서 제공하는 sqlSession클래스에 종속되어있음
	//root-context.xml에서 mybatis 관련 설정 확인
	@Inject
	SqlSessionTemplate  sqlSessionTemplate;
	
	final String NAMESPACE = "mapper.HomeMapper";
	
	
	public HomeDaoImple() {}
	
	
	@SuppressWarnings("deprecation")
	public List<HomeVO>  getAll(){
		List<HomeVO>  list = new ArrayList<HomeVO>();
		
        String statement = this.NAMESPACE +".getAllHome";
		
		list = this.sqlSessionTemplate.selectList(statement);
		
		for (HomeVO vo : list) {
			LOG.debug("vo:" + vo);
		}	
		return list;
	}

	@Override
	public int getHomeCount() throws SQLException {
		int count = 0;
		String statement = NAMESPACE +".getHomeCount";
		
		count = this.sqlSessionTemplate.selectOne(statement);
		LOG.debug("==============================");
		LOG.debug("======getHomeCount======");
		LOG.debug("=count="+count);
		LOG.debug("==============================");			
		
		return count;
	}

	@Override
	public void deleteHomeAll() throws SQLException {
		String statement = NAMESPACE+".deleteHomeAll";
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
	public int InsertHome(HomeVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE +".InsertHome";
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
	public HomeVO SelectHome(HomeVO inVO) throws SQLException {
		HomeVO outVO = null;
		String statement = NAMESPACE +".SelectHome";
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
	public int DeleteHome(HomeVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".DeleteHome";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
	}

	@Override
	public int UpdateHome(HomeVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE +".UpdateHome";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");		
		flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("flag="+flag);
		return flag;
	}



	@Override
	public HomeVO locationLike(HomeVO inVO) throws SQLException {
		HomeVO outVO = null;
		String statement = NAMESPACE +".locationLike";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		outVO = sqlSessionTemplate.selectOne(statement,inVO);
		LOG.debug("outVO"+outVO.toString());
		LOG.debug("============================");
		return outVO;
	}
	
	@Override
	public List<HomeVO> getHomeListBySearchBar(String location, String startDate, String endDate,
			int numberOfPeople) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("location", location);
		parameters.put("startDate", startDate);
		parameters.put("endDate", endDate);
		parameters.put("numPeople", numberOfPeople);
		
		return sqlSessionTemplate.selectList("getHomeListBySearchBar", parameters);
		
	}
}
