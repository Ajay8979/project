package com.ojas.gst.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import com.ojas.gst.entity.Entity;




/**
 * @param <T>
 *            Type of the Entity.
 * @param <I>
 *            Type of the Primary Key.
 * @author DhanaLakshmi
 */
public class JpaDao<T extends Entity, I> implements Dao<T, I> {
	private EntityManager entityManager;

	protected Class<T> entityClass;

	public JpaDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Transactional(readOnly = true)
	public List<T> findAll() {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = builder.createQuery(this.entityClass);
		criteriaQuery.from(this.entityClass);

		TypedQuery<T> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}
	

	
	@Transactional(readOnly = true)
	public T find(I id) {
		return this.getEntityManager().find(this.entityClass, id);
	}

	
	@Transactional
	public T save(T entity) {
		return this.getEntityManager().merge(entity);
	}

	
	@Transactional
	public void delete(I id) {
		if (id == null) {
			return;
		}

		T entity = this.find(id);
		if (entity == null) {
			return;
		}

		this.getEntityManager().remove(entity);
	}

	
	@Transactional
	public void delete(T entity) {
		this.getEntityManager().remove(entity);
	}

	public Long calculateMaxId(Entity entity) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		/*
		 * Root root = cq.from(entity.getClass()); cq.select(cb.max(root.get("id")));
		 */
		Query tq = this.getEntityManager().createQuery(cq);
		Long result = (Long) tq.getSingleResult();
		return result;
	}

}
