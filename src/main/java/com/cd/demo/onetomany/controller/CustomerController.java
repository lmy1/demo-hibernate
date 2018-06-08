package com.cd.demo.onetomany.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.demo.onetomany.dao.CustomerDao;
import com.cd.demo.onetomany.pojo.Customer;
import com.cd.demo.onetomany.pojo.Linkman;
import com.cd.demo.onetomany.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping
	public Integer addCustomer(@RequestBody Customer customer) {
		
		Set<Linkman> linkmans = customer.getLinkmans();
		if (null != linkmans) {
			for (Linkman linkman : linkmans) {
				linkman.setCustomer(customer);
			}
		}
		customerDao.save(customer);
		return customer.getId();
	}
	
	@DeleteMapping("/{ids}")
	public void deleteCustomer(@PathVariable("ids")List<Integer> ids) {
		
		List<Customer> customers = customerDao.findAll(ids);
		customerDao.delete(customers);
	}
	
	@GetMapping("/{id}")
	public Customer findCustomer(@PathVariable("id")Integer id) {
		
		Customer customer= customerService.findCustomer(id);
		customer.getLinkmans().size();
		return customer;
	}
}
