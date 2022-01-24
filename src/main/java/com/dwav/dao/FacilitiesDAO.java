package com.dwav.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwav.vo.FacilitiesVO;
import com.dwav.vo.SearchVO;






@Repository("facilitiesDAO")
public class FacilitiesDAO {
	
	final static Logger LOG = LogManager.getLogger(FacilitiesDAO.class);
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; 

	final String NAMESPACE = "dwav";
	
	
	public FacilitiesDAO() {}
//	CRUDs
	
	//삭제///////////////////////////////////////////////////////////////////////////
    /**
     * 편의시설 전체 삭제 
     * @throws SQLException
     */
    public void deleteAllAmen() throws SQLException{
    	String statement = NAMESPACE+".deleteAllAmen";
    	LOG.debug("==============================");
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		int flag = this.sqlSessionTemplate.delete(statement);
		LOG.debug("==============================");
		LOG.debug("=flag="+flag);
		LOG.debug("==============================");    	
    }
    
    
	/**
	 * 숙소 별 편의시설 전체 삭제
	 */
	public int deleteAmenAccom(FacilitiesVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".deleteAmenAccom";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
	}
	
	/**
	 * 편의시설 단건 삭제
	 */
	public int doDeleteAmen(FacilitiesVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".doDeleteAmen";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
	}
	//삭제///////////////////////////////////////////////////////////////////////////    
    
	//생성///////////////////////////////////////////////////////////////////////////
	
	/**OK
	 * 편의시설 등록
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int doInsertAmen(FacilitiesVO inVO) throws SQLException{
		int flag = 0;
		String statement = NAMESPACE +".doInsertAmen";
		
		LOG.debug("==============================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("==============================");	
		
		flag = this.sqlSessionTemplate.insert(statement, inVO);
	    LOG.debug("flag:"+flag);
		return flag;
	}
	//생성///////////////////////////////////////////////////////////////////////////
	
	//수정///////////////////////////////////////////////////////////////////////////
	
	/**
	 * 편의시설 수정
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public int doUpdateAmen(FacilitiesVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE +".doUpdateAmen";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");		
		flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("flag="+flag);
		return flag;
	}
	//수정///////////////////////////////////////////////////////////////////////////

	
	//조회///////////////////////////////////////////////////////////////////////////
	
	/**
	 * 편의시설 검색(SearchVO)
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public List<FacilitiesVO> doRetrieveAmen(SearchVO inVO) throws SQLException {

		String statement = NAMESPACE +".doRetrieveAmen";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		List<FacilitiesVO> list = sqlSessionTemplate.selectList(statement, inVO);
		
		for(FacilitiesVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
		
	}
	
	
	public FacilitiesVO doSelectAmen(FacilitiesVO inVO) throws SQLException{
		FacilitiesVO outVO = null;
		String statement = NAMESPACE +".doSelectAmen";
		
		LOG.debug("==============================");
		LOG.debug("=inVO="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		
		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("==============================");
		LOG.debug("=outVO="+outVO.toString());
		LOG.debug("==============================");	
		return outVO;
	}
	
	public int getCountAmen() throws SQLException{
		int count = 0;
		String statement = NAMESPACE +".getCountAmen";
		
		count = this.sqlSessionTemplate.selectOne(statement);
		LOG.debug("==============================");
		LOG.debug("=count="+count);
		LOG.debug("==============================");			
		
		return count;
	}
	
	
	public FacilitiesVO findAccom (FacilitiesVO inVO) throws SQLException{
		FacilitiesVO outVO = null;
		
		String statement = NAMESPACE +".findAccom";
		LOG.debug("==============================");
		LOG.debug("=inVO="+inVO.toString());
		LOG.debug("=statement="+statement);
		
		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("=outVO="+outVO.toString());
		LOG.debug("==============================");
		
		return outVO;
		
	}
	
	
	
	public List<FacilitiesVO>  getAllAmen(){
		List<FacilitiesVO>  list = new ArrayList<FacilitiesVO>();
		
        String statement = this.NAMESPACE +".getAllAmen";
		
		list = this.sqlSessionTemplate.selectList(statement);
		
		for (FacilitiesVO vo : list) {
			LOG.debug("vo:" + vo);
		}
		
		
		return list;
	}
	//조회///////////////////////////////////////////////////////////////////////////

//	Functional Methods
}