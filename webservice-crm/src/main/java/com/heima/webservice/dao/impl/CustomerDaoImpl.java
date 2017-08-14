package com.heima.webservice.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.heima.webservice.dao.CustomerDao;
import com.heima.webservice.domain.Customer;

@Repository
@SuppressWarnings("all")
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Autowired
	public void setXXX(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public List<Customer> queryAll() {
		try {
			List<Customer> list = getHibernateTemplate().find("from Customer");
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public Customer findById(String id) {
		try {
			List<Customer> list = getHibernateTemplate().find("from Customer where id = ?",Integer.parseInt(id));
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Customer> queryByCondition(String id, String address, String telephone) {

		try {
			Criteria criteria = getSession().createCriteria(Customer.class);

			if (id != null) {
				criteria.add(Restrictions.eq("id", Integer.parseInt(id)));
			}
			if (StringUtils.isNotBlank(address)) {
				criteria.add(Restrictions.like("address", "%"+address+"%"));
			}
			if (StringUtils.isNotBlank(telephone)) {
				criteria.add(Restrictions.eq("telephone", telephone));
			}
			List list = getHibernateTemplate().findByCriteria((DetachedCriteria) criteria);

			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Customer add(Customer c) {
		
		Serializable id = getHibernateTemplate().save(c);
		c.setId((Integer)id);
		return c;
	}

	@Override
	public void update(String id,String address) {
		getSession().createQuery("update Customer set address = ? where id = ?")
								.setParameter(0, address).setParameter(1, Integer.parseInt(id)).executeUpdate();
		
	}

}
