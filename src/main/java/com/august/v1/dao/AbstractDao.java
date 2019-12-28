package com.august.v1.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) throws Exception {
		Session session = null;
		try {
			session = getSession();
			return (T) session.get(persistentClass, key);
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void persist(T entity) {
		Session session = null;
		try {
			session = getSession();
			session.persist(entity);
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void update(T entity) {
		Session session = null;
		try {
			session = getSession();
			session.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void saveOrUpdate(T entity) {
		Session session = null;
		try {
			session = getSession();
			session.saveOrUpdate(entity);
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void delete(T entity) {
		Session session = null;
		try {
			session = getSession();
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	@SuppressWarnings("unchecked")
	protected List<T> list() {
		Session session = null;
		try {
			session = getSession();
			return session.createCriteria(persistentClass).list();
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected List<T> getList(Criterion criterion) {
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(persistentClass);
			if (criterion != null)
				criteria.add(criterion);
			return criteria.list();
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	protected long getCount(Criterion criterion) {
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(persistentClass);
			if (criterion != null)
				criteria.add(criterion);
			return (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	protected List getListByProjection(List<String> properties, Criterion critrion) {
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(persistentClass);
			if(critrion != null) 
				criteria.add(critrion);
			ProjectionList projections = Projections.projectionList();
			properties.forEach(property ->{
				projections.add(Projections.property(property));
			});
			criteria.setProjection(projections);
			return criteria.list();
		}catch(Exception e) {
			throw e;
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	protected List getResultByNativeQuery(String query, Map<String,Object> parameters) {
		Session session = null;
		try {
			session = getSession();
			final SQLQuery sqlQuery = session.createSQLQuery(query);
			parameters.forEach((k,v) ->sqlQuery.setParameter(k,v));
			return sqlQuery.list();
		}catch(Exception e){
			throw e;
		}finally {
			if(session !=null) {
				session.close();
			}
		}
	}
}
