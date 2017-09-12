package com.llc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.llc.entity.User;
import com.llc.mapper.UserMapper;
import com.llc.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;

	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		List<User> list = userMapper.findUser(username, password);
		if (list == null || list.size() < 1)
			return null;
		else
			return list.get(0);
	}

}
