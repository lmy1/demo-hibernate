package com.cd.demo.onetomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cd.demo.onetomany.pojo.Linkman;

public interface LinkmanDao extends  JpaRepository<Linkman, Integer>,JpaSpecificationExecutor<Linkman>{
	public boolean existsByLkmNameAndLkmGender(String lkmName, String lkmGender);
}
