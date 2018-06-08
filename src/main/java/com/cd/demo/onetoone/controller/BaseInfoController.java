package com.cd.demo.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.demo.onetoone.dao.BaseInfoDao;
import com.cd.demo.onetoone.pojo.BaseInfo;
import com.cd.demo.onetoone.pojo.ComplexInfo;

@RestController
@RequestMapping("/baseInfo")
public class BaseInfoController {
	
	@Autowired
	private BaseInfoDao baseInfoDao;
	
	
	@PostMapping
	public Integer addCustomer(@RequestBody BaseInfo baseInfo) {
		
		ComplexInfo complexInfo = baseInfo.getComplexInfo();
		complexInfo.setBaseInfo(baseInfo);
		
		baseInfoDao.save(baseInfo);
		return baseInfo.getId();
	}
	
	@GetMapping("/{id}")
	public BaseInfo findBaseInfo(@PathVariable("id")Integer id) {
		
		BaseInfo baseInfo = baseInfoDao.findOne(id);
		return baseInfo;
	}
}
