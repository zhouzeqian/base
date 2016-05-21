package com.hzlh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hzlh.dao.UserMapper;
import com.hzlh.entity.MyUserDetails;
import com.hzlh.entity.User;
import com.hzlh.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.userMapper.findByUserName(username);
		if(user==null){
			throw new UsernameNotFoundException("用户不存在！");
		}
		
		return new MyUserDetails(user);
	}
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(id);
	}

}
