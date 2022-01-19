package com.dwav.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwav.dao.FacilitiesDAO;
import com.dwav.vo.BookingDateVO;
import com.dwav.vo.FacilitiesVO;

@Repository
public class FacilitiesDAOImp implements FacilitiesDAO {

	@Autowired
	SqlSession session;
	
	@Override
	public int addAmenity(FacilitiesVO amen) {
		return session.insert("insertAmenity", amen);
	}

	@Override
	public int addAmenityList(List<FacilitiesVO> amenList) {
		int cnt = 0;
		for (FacilitiesVO aVO : amenList) {
			cnt += session.insert("insertAmenity", aVO);
		}
		return cnt;
	}

	@Override
	public List<FacilitiesVO> getAmenityListByAccomID(int accom_id) {
		return session.selectList("getAmenityListByAccomId", accom_id);
	}
	
	@Override
	public int updateAmentiyList(int accom_id, List<FacilitiesVO> amenList) {
		int cnt = 0;
		cnt += session.delete("deleteAmenityListByAccomId", accom_id);
		for (FacilitiesVO aVO : amenList) {
			cnt += session.insert("insertAmenity", aVO);
		}
		return cnt;
	}

	@Override
	public int deleteAmenityListByAccomID(int accom_id) {
		return session.delete("deleteAmenityListByAccomId", accom_id);
	}

	

}
