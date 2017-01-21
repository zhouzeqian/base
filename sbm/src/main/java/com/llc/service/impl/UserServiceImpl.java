package com.llc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.llc.base.BaseResult;
import com.llc.entity.User;
import com.llc.mapper.UserMapper;
import com.llc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;

	@Override
	public BaseResult<User> fingById(Long id) {
		// TODO Auto-generated method stub
		BaseResult<User> br=new BaseResult<User>();
		br.setCode("SUCCESS");
		br.setMsg("获取用户信息成功");
		br.setObj(userMapper.selectByPrimaryKey(id));
		return br;
	}

}
