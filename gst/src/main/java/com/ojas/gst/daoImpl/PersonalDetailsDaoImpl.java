package com.ojas.gst.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.ojas.gst.dao.JpaDao;
import com.ojas.gst.dao.PersonalDetailsDao;
import com.ojas.gst.entity.BusinessDetails;
import com.ojas.gst.entity.DocumentsDetails;
import com.ojas.gst.entity.PersonalInfo;


public class PersonalDetailsDaoImpl extends JpaDao<PersonalInfo, Long> implements PersonalDetailsDao {
	
	public PersonalDetailsDaoImpl(Class<PersonalInfo> entityClass) {
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
	
	
	public PersonalInfo getBusinessDeatailsById(Integer id){
		TypedQuery<PersonalInfo> createQuery = this.entityManager.createQuery(
				"from personal_info  where id='"+id,
				PersonalInfo.class);
		        List<PersonalInfo> resultList = createQuery.getResultList();

//		TXPResponse txpResponse = new TXPResponse();
		       // BusinessDetails businessDetails = new BusinessDetails();
		        PersonalInfo p=new PersonalInfo();
		for (PersonalInfo gstr1Request : resultList) {
			List<DocumentsDetails> txpda = gstr1Request.getDocumentsDetails();
			p.setDocumentsDetails(txpda);

		}

		return p;
	}
	
	
	
	
	
	
	
	
}
