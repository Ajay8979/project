package com.ojas.gst.daoImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.ojas.gst.dao.BusinessDetailsDao;
import com.ojas.gst.dao.JpaDao;
import com.ojas.gst.entity.BusinessDetails;
import com.ojas.gst.entity.DocumentsDetails;
import com.ojas.gst.entity.ExistingRegistrationDetail;
import com.ojas.gst.entity.JurisdictionDetails;
import com.ojas.gst.returns.entity.Gstr1Request;
import com.ojas.gst.returns.entity.HSNData;
import com.ojas.gst.returns.entity.HSNResponse;

public class BusinessDetailsDaoImpl extends JpaDao<BusinessDetails, Long> implements BusinessDetailsDao {
	
	public BusinessDetailsDaoImpl(Class<BusinessDetails> entityClass) {
		super(entityClass);
	}
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public BusinessDetails getBusinessDeatailsById(Integer id){
		TypedQuery<BusinessDetails> createQuery = this.entityManager.createQuery(
				"from Gst_business_details g where id='"+id,
				BusinessDetails.class);
		        List<BusinessDetails> resultList = createQuery.getResultList();

		        BusinessDetails businessDetails = new BusinessDetails();
		        
		for (BusinessDetails gstr1Request : resultList) {
			List<DocumentsDetails> txpda = gstr1Request.getDocumentsDetails();
			businessDetails.setDocumentsDetails(txpda);

		}

		return businessDetails;
	}
	
	public BusinessDetails getJurisdictionDetailsByBusinessDetailsId(Integer id){
		TypedQuery<BusinessDetails> createQuery = this.entityManager.createQuery(
				"from Gst_business_details g where id='"+id,
				BusinessDetails.class);
		        List<BusinessDetails> resultList = createQuery.getResultList();
		        BusinessDetails businessDetails = new BusinessDetails();		        
		for (BusinessDetails gstr1Request : resultList) {
			
JurisdictionDetails j=gstr1Request.getJurisdiction();
		}

		return businessDetails;
	}
	
	
	public ExistingRegistrationDetail getExistingRegistrationDetailBYId(Integer id){
		TypedQuery<ExistingRegistrationDetail> createQuery = this.entityManager.createQuery(
				"from Gst_business_details g where id='"+id,
				ExistingRegistrationDetail.class);
		        List<ExistingRegistrationDetail> resultList1 = createQuery.getResultList();
		       // BusinessDetails businessDetails = new BusinessDetails();
		        ExistingRegistrationDetail exis=new ExistingRegistrationDetail();
		for (ExistingRegistrationDetail gstr1Request : resultList1) {
			
			Date e=gstr1Request.getDateOfRegistration();
			String e1=gstr1Request.getType();
		}

		return exis;
	}
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
