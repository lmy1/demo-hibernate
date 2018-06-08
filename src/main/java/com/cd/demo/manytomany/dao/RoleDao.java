package com.cd.demo.manytomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cd.demo.manytomany.pojo.Role;

public interface RoleDao extends JpaRepository<Role, Integer>,JpaSpecificationExecutor<Role>{

}
