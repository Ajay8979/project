package com.ojas.gst.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import javax.transaction.Transactional;


import com.ojas.gst.entity.District;


public class JpaDistrictDao extends JpaDao<District, Long> implements DistrictDao{
	
	public JpaDistrictDao() {
		super(District.class);
	}

	@Override
	public List<District> getAllDistricts() {
		Query query = getEntityManager().createNativeQuery(
				" select district_id,district_name,district_updatedBy,district_updatedDate,district_status,district_email from gst.district  order by district_id desc");
		@SuppressWarnings("unchecked")
		List<Object[]> districtsObjectList = query.getResultList();
		List<District> districtsList = new ArrayList<District>();

		for (Object[] object : districtsObjectList) {
			District district = new District();
			district.setId(Long.parseLong(object[0] + ""));
			district.setDistrictName((object[1] + ""));
			if(object[2] != null) {
				district.setLastUpdatedBy(Long.parseLong(object[2] + ""));
			}			
			district.setUpdatedDate((Date) object[3]);
			district.setStatus(object[4] + "");
			district.setEmail(object[5] + "");
			districtsList.add(district);
		}
		return districtsList;
	}
 
    @Transactional
	@Override
	public int deleteById(District district) {
		Query query = getEntityManager().createNativeQuery("update district set district_status='"
				+ district.getStatus() + "' where district_id=" + district.getId());
		return query.executeUpdate();
	}
    @Transactional
	@Override
	public int updateDistrictById(District district) {
		Query query = getEntityManager().createNativeQuery("update district set district_status='"
				+ district.getStatus() + "',district_name ='"+district.getDistrictName()+ "',district_updatedBy ='"+district.getLastUpdatedBy()+"',district_updatedDate ='"+district.getUpdatedDate()+"'where district_id=" + district.getId());
		return query.executeUpdate();
	}

}
