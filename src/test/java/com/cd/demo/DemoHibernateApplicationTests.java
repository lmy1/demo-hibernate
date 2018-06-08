package com.cd.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cd.demo.onetomany.dao.LinkmanDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoHibernateApplicationTests {

	@Autowired LinkmanDao linkmanDao;
	
	@Test
	public void contextLoads() {
		System.out.println(linkmanDao.existsByLkmNameAndLkmGender("张三","男"));
	}

}
