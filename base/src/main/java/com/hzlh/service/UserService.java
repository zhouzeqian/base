package com.hzlh.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hzlh.entity.User;

public interface UserService extends UserDetailsService{

	public User findById(Integer id);
}
