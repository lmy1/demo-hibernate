package com.cd.demo.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.demo.onetomany.dao.LinkmanDao;
import com.cd.demo.onetomany.pojo.Linkman;

@RestController
@RequestMapping("/linkman")
public final class LinkmanController {
	
	@Autowired
	private LinkmanDao linkmanDao;
	
	@GetMapping("/{id}")
	public Linkman findLinkman(@PathVariable("id")Integer id) {
		Linkman linkman = linkmanDao.findOne(id);
		return linkman;
	}
}
