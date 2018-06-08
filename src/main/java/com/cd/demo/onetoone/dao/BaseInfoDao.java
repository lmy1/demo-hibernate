package com.cd.demo.onetoone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cd.demo.onetoone.pojo.BaseInfo;

public interface BaseInfoDao extends JpaRepository<BaseInfo, Integer>,JpaSpecificationExecutor<BaseInfo>{

}
