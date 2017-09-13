package com.llc.mapper;

import java.util.List;
import java.util.Map;

import com.llc.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> findUser(Map<String,Object> map);
    
    List<User> findByName(String username);
}