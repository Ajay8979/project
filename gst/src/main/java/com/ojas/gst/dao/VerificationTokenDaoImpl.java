package com.ojas.gst.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ojas.gst.entity.VerificationToken;



@Repository
public class VerificationTokenDaoImpl extends JpaDao<VerificationToken,Long> implements VerificationTokenDao {

	public VerificationTokenDaoImpl(Class<VerificationToken> entityClass) {
		super(entityClass);
	}
	
	public VerificationTokenDaoImpl()
	{
		super(VerificationToken.class);
	}

	@Override
	public VerificationToken findByToken(String token) {
		final CriteriaBuilder builder=this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<VerificationToken> criteriaQuery=builder.createQuery(this.entityClass);
		Root<VerificationToken> root=criteriaQuery.from(this.entityClass);
		Path<String> pathName=root.get("token");
		criteriaQuery.where(builder.equal(pathName, token));
		TypedQuery<VerificationToken> typedQuery=this.getEntityManager().createQuery(criteriaQuery);
		VerificationToken verifiedToken=typedQuery.getSingleResult();
		return verifiedToken;
	}

	@Override
	public VerificationToken findByUser(String token) {
		return null;
	}

}

