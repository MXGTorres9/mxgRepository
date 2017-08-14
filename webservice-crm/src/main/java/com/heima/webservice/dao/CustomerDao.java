package com.heima.webservice.dao;

import java.util.List;

import com.heima.webservice.domain.Customer;

public interface CustomerDao {

	List<Customer> queryAll();

	Customer findById(String id);

	List<Customer> queryByCondition(String id, String address, String telephone);

	Customer add(Customer c);

	void update(String id, String address);

}
