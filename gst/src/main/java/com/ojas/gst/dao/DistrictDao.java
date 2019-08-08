package com.ojas.gst.dao;

import java.util.List;


import com.ojas.gst.entity.District;


public interface DistrictDao  extends Dao<District, Long>{

	List<District> getAllDistricts();

	int deleteById(District district);
	
	int updateDistrictById(District district);
	
}
