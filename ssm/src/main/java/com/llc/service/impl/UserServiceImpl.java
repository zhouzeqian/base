package com.llc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.llc.entity.Permission;
import com.llc.entity.Role;
import com.llc.entity.User;
import com.llc.mapper.PermissionMapper;
import com.llc.mapper.RoleMapper;
import com.llc.mapper.UserMapper;
import com.llc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;
	@Resource
	RoleMapper roleMapper;
	@Resource
	PermissionMapper permissionMapper;

	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> map = Maps.newHashMap();
		map.put("username", username);
		map.put("password", password);
		List<User> list = userMapper.findUser(map);
		if (list == null || list.size() < 1)
			return null;
		else
			return list.get(0);
	}

	@Override
	public User findByName(String username) {
		List<User> list = userMapper.findByName(username);
		if (list == null || list.size() < 1)
			return null;
		else
			return list.get(0);
	}

	@Override
	public List<Role> findByUserId(Integer uid) {

		return roleMapper.findByUserId(uid);
	}

	@Override
	public List<Permission> findByRoleId(Integer rid) {
		// TODO Auto-generated method stub
		return permissionMapper.findByRoleId(rid);
	}

	@Override
	public Integer add(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer update(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User find(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

}
