package com.llc.service;

import java.util.List;

import com.llc.entity.Permission;
import com.llc.entity.Role;
import com.llc.entity.User;

public interface UserService {

	User findUser(String username, String password);

	User findByName(String username);

	List<Role> findByUserId(Integer uid);

	List<Permission> findByRoleId(Integer rid);

	Integer add(User user);

	Integer delete(Integer id);

	Integer update(User user);

	User find(Integer id);
}
