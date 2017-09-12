package com.llc.service;

import com.llc.entity.User;

public interface UserService {

	User findUser(String username,String password);
}
