package com.cd.demo.onetomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cd.demo.onetomany.pojo.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>,JpaSpecificationExecutor<Customer>{

}
