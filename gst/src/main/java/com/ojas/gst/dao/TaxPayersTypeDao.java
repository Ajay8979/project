package com.ojas.gst.dao;

import java.util.List;

import com.ojas.gst.dto.TaxPayersTypeDTO;
import com.ojas.gst.entity.TaxPayersType;

public interface TaxPayersTypeDao extends Dao<TaxPayersType, Long>{
	
	List<TaxPayersTypeDTO> getAllTaxPayersTypes();

	int deleteById(TaxPayersType taxPayersType);
	
	int updateTaxPayersTypeById(TaxPayersType taxPayersType);

}
