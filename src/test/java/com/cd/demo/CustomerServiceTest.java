package com.cd.demo;

import javax.transaction.Transactional;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.cd.demo.onetomany.dao.CustomerDao;
import com.cd.demo.onetomany.dao.LinkmanDao;
import com.cd.demo.onetomany.pojo.Customer;
import com.cd.demo.onetomany.pojo.Linkman;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private LinkmanDao linkmanDao;
	
	@Test
	public void saveTest() {
		//保存主表数据
		Customer customer = new Customer();
//		customer.setCustName("王老板");
//		customer.setCustPhone("150");
		customer.setId(1);
		
		//保存从表数据
		Linkman linkman = new Linkman();
		linkman.setLkmName("阿八");
		linkman.setLkmGender("男");
		
		//保存关联数据
		linkman.setCustomer(customer);	//保存从表时想保存外键，从表对象中的主表对象只有有主键数据即可
//		customerDao.save(customer);
		linkmanDao.save(linkman);	
//		customer.get
		
	}
	
	@Test
	public void deleteTest() {
		//如果配外键约束，从表有数据关联主表，则不能删除该主表数据，要删除需要配置级联删除；但是没有配外键约束则可以删除主表数据，而且从表数据还在
		customerDao.delete(4);	
	}
	
	@Test
	@Transactional
	public void findTest() {
		
		Customer customer = customerDao.findOne(1);
		System.out.println(ReflectionToStringBuilder.toString(customer, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(JSON.toJSONString(customer));
	}
}


























