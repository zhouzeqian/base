package com.llc.service;

import java.util.List;

import com.llc.base.BaseResult;
import com.llc.entity.User;

public interface UserService {
	public BaseResult<List<User>> find();
}
