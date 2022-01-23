package com.dwav.dao;

import java.util.List;

import com.dwav.vo.FacilitiesVO;

public interface FacilitiesDAO {
//	CRUDs
	public int addAmenity(FacilitiesVO amen);
	//각종 욕실용품과 소모품을 일컫는 말입니다.
	public int addAmenityList(List<FacilitiesVO> amenList);
	public List<FacilitiesVO> getAmenityListByAccomID(int accom_id);
	public int updateAmentiyList(int accom_id, List<FacilitiesVO> amenList);
	public int deleteAmenityListByAccomID(int accom_id);
//	Functional Methods
}
