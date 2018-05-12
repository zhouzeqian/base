package com.kxll.Service;

import com.kxll.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User find(Long id);

    public User findByUserName(String username);

    List<Map<String,Object>> findRoles(Long userId);

    List<String> findPermissions(Long roleId);
}
