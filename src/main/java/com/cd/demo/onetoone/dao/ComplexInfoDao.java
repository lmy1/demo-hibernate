package com.cd.demo.onetoone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cd.demo.onetoone.pojo.ComplexInfo;

public interface ComplexInfoDao extends  JpaRepository<ComplexInfo, Integer>,JpaSpecificationExecutor<ComplexInfo>{
}
