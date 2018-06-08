package com.cd.demo.manytomany.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.demo.manytomany.dao.RoleDao;
import com.cd.demo.manytomany.pojo.Role;
import com.cd.demo.manytomany.pojo.User;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleDao roleDao;
	
	@GetMapping("/{id}")
	public Role findRole(@PathVariable("id")Integer id) {
		
		Role role = roleDao.findOne(id);
//		role.getUsers().size();
		return role;
	}
	
	@PutMapping(value = "/{id}")
    public void updateRole(@PathVariable Integer id, @RequestBody Role role) throws Exception{
        Set<User> Users = role.getUsers();
		if (Users != null) {
			for (User User : Users) {
                if (User.getId() == null) {
                    throw new Exception("缺少主键");
				}

                Set<Role> roles = User.getRoles();
				if (roles == null) {
					roles = new HashSet<Role>();
				}

				roles.add(role);
				User.setRoles(roles);

			}
		}
		role.setId(id);
        roleDao.save(role);
	}

}


















