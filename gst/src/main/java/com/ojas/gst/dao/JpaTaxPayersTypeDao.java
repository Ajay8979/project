package com.ojas.gst.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;
import com.ojas.gst.dto.TaxPayersTypeDTO;
import com.ojas.gst.entity.TaxPayersType;

public class JpaTaxPayersTypeDao extends JpaDao<TaxPayersType, Long> implements TaxPayersTypeDao{

	public JpaTaxPayersTypeDao() {
		super(TaxPayersType.class);
	}
	
	@Override
	public List<TaxPayersTypeDTO> getAllTaxPayersTypes() {
		Query query = getEntityManager().createNativeQuery(
				" select taxpayerstype_id,taxpayerstype_name,taxpayerstype_updatedBy,taxpayerstype_updatedDate,taxpayerstype_status,taxpayerstype_email from gst.taxpayerstype  order by taxpayerstype_id desc");
		@SuppressWarnings("unchecked")
		List<Object[]> taxpayerstypeList = query.getResultList();
		List<TaxPayersTypeDTO> taxPayersTypeDTOList = new ArrayList<TaxPayersTypeDTO>();

		for (Object[] object : taxpayerstypeList) {
			TaxPayersTypeDTO taxPayersTypeDTO = new TaxPayersTypeDTO();
			taxPayersTypeDTO.setId(Long.parseLong(object[0] + ""));
			taxPayersTypeDTO.setTaxPayersType((object[1] + ""));
			if(object[2] != null) {
				taxPayersTypeDTO.setLastUpdatedBy(Long.parseLong(object[2] + ""));	
			}
			taxPayersTypeDTO.setUpdatedDate((Date) object[3]);
			taxPayersTypeDTO.setStatus(object[4] + "");
			 taxPayersTypeDTO.setEmail(object[5] + "");
			taxPayersTypeDTOList.add(taxPayersTypeDTO);
		}
		return taxPayersTypeDTOList;
	}

	@Transactional
	@Override
	public int deleteById(TaxPayersType taxPayersType) {
		Query query = getEntityManager().createNativeQuery("update taxpayerstype set taxpayerstype_status='"
				+ taxPayersType.getStatus() + "' where taxpayerstype_id=" + taxPayersType.getId());
		return query.executeUpdate();
	}

	@Override
	public int updateTaxPayersTypeById(TaxPayersType taxPayersType) {
		Query query = getEntityManager().createNativeQuery("update taxpayerstype set taxpayerstype_status='"
				+ taxPayersType.getStatus() + "',taxpayerstype_name ='"+taxPayersType.getTaxpayerstypeName()+ "',taxpayerstype_updatedBy ='"+taxPayersType.getLastUpdatedBy()+"'taxpayerstype_updatedDate'"+taxPayersType.getUpdatedDate()+"'where taxpayerstype_id=" + taxPayersType.getId());
		return query.executeUpdate();
	}

}
