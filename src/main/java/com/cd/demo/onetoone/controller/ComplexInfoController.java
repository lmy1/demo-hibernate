package com.cd.demo.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.demo.onetoone.dao.ComplexInfoDao;
import com.cd.demo.onetoone.pojo.ComplexInfo;

@RestController
@RequestMapping("/complexInfo")
public class ComplexInfoController {
	@Autowired
	private ComplexInfoDao complexInfoDao;
	
	@GetMapping("/{id}")
	public ComplexInfo findComplexInfo(@PathVariable("id")Integer id) {
		
		ComplexInfo complexInfo = complexInfoDao.findOne(id);
		return complexInfo;
	}
	
	@DeleteMapping("/{id}")
	public void deleteComplexInfo(@PathVariable("id")Integer id) {
		
		complexInfoDao.delete(id);
	}
}
