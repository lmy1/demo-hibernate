package com.cd.demo.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd.demo.onetomany.dao.CustomerDao;
import com.cd.demo.onetomany.pojo.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Transactional
	public Customer findCustomer(Integer id) {
		
		return customerDao.findOne(id);
	}
	
}
