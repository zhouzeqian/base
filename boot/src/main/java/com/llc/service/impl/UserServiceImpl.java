package com.llc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.llc.base.BaseResult;
import com.llc.entity.User;
import com.llc.repository.UserRepository;
import com.llc.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserRepository userRepository;
	@Override
	public BaseResult<List<User>> find() {
		BaseResult<List<User>> br = new BaseResult<List<User>>();
		br.setCode("SUCCESS");
		br.setMsg("获取用户列表成功");
		br.setObj(this.userRepository.findAll());
		return br;
	}

}
