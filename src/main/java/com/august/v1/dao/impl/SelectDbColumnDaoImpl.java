package com.august.v1.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.august.v1.dao.AbstractDao;
import com.august.v1.dao.SelectDbColumnDao;
import com.august.v1.domain.entity.GuestEntityBean;

@Repository
public class SelectDbColumnDaoImpl extends AbstractDao<Long, GuestEntityBean> implements SelectDbColumnDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<GuestEntityBean> selectAllDbColumn() {
		System.out.println("Inside SelectDbColumnDaoImpl");
		Session session = null;
		List<GuestEntityBean> guestList = null;
		try {
			String hql = "from GuestEntityBean";
			session = getSession();
			/*Query query = session.createQuery(hql);
			 guestList = query.list();*/
			Criteria criteria = session.createCriteria(GuestEntityBean.class);
			criteria.add(Restrictions.eq("VerifyStatus", "Y"));
			guestList = criteria.list();
			System.out.println("Guest List : " + guestList);
			return guestList;
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session !=null) {
				session.close();
			}
		}
		return guestList;
	}

}
