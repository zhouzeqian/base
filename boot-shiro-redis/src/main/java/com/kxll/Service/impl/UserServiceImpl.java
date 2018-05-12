package com.kxll.Service.impl;

import com.kxll.Service.UserService;
import com.kxll.entity.User;
import com.kxll.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User find(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<Map<String, Object>> findRoles(Long userId) {
        return userMapper.findRoles(userId);
    }

    @Override
    public List<String> findPermissions(Long roleId) {
        return userMapper.findPermissions(roleId);
    }
}
