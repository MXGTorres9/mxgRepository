package com.heima.webservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.webservice.dao.CustomerDao;
import com.heima.webservice.domain.Customer;
import com.heima.webservice.service.CustomerServcie;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServcie {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> queryAll() {
		
		return customerDao.queryAll();
	}

	@Override
	public Customer queryById(String id) {
		
		return customerDao.findById(id);
	}

	@Override
	public List<Customer> queryByCondition(String id, String address, String telephone) {
		
		return customerDao.queryByCondition(id, address,telephone);
	}

	@Override
	public Customer add(Customer c) {
		
		return customerDao.add(c);
	}

	@Override
	public void update(String id,String address) {
			
		customerDao.update(id,address);
	}

}
