package com.llc.service;

import com.llc.base.BaseResult;
import com.llc.entity.User;

public interface UserService {
	BaseResult<User> fingById(Long id);
}
