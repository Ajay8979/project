package com.ojas.gst.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ojas.gst.entity.FileGSTR3BData;
import com.ojas.gst.entity.GSTR3BEntity;
import com.ojas.gst.entity.RefferenceId;

public class JpaFileGSTR3BData extends JpaDao<FileGSTR3BData, Long> implements FileGSTR3BDataDao {

	public JpaFileGSTR3BData() {
		super(FileGSTR3BData.class);
	}

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public RefferenceId findByGstinAndRet_period(GSTR3BEntity entity) {
		Query nativeQuery = this.entityManager.createNativeQuery("select * from filegstr3bdata where gstin = '"
				+ entity.getGstin() + "' and ret_period ='" + entity.getRet_period() + "'");
		List<Object[]> resultList = nativeQuery.getResultList();
		RefferenceId refferenceId = new RefferenceId();
		for (Object[] result : resultList) {
			String string = result[2].toString();
			refferenceId.setRef_id(string);
			return refferenceId;
		}
		return null;

	}

	@Override
	public FileGSTR3BData findByFileGSTR3B(GSTR3BEntity entity) {

		TypedQuery<FileGSTR3BData> createQuery = this.entityManager.createQuery("from FileGSTR3BData f where f.gstin ='"
				+ entity.getGstin() + "' and f.ret_period ='" + entity.getRet_period() + "'", FileGSTR3BData.class);
		// createQuery.setParameter(0, entity.getGstin());
		// createQuery.setParameter(1, entity.getRet_period());
		/*
		 * List<Object[]> resultList = (List<Object[]>) nativeQuery.getResultList();
		 * FileGSTR3BData fileGSTR3B = new FileGSTR3BData(); for (Object[] result :
		 * resultList) { fileGSTR3B.setId(Long.parseLong(result[0] + ""));
		 * fileGSTR3B.setGstin(result[1] + ""); fileGSTR3B.setRef_id(result[2]+"");
		 * fileGSTR3B.setRet_period(result[3] + ""); } return fileGSTR3B;
		 */
		List<FileGSTR3BData> resultList = createQuery.getResultList();
		for (FileGSTR3BData fileGSTR3BData : resultList) {
			return fileGSTR3BData;
		}
		return null;

	}
}
