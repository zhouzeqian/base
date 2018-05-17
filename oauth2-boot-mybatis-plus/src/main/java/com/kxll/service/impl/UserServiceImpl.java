package com.kxll.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kxll.entity.User;
import com.kxll.mapper.UserMapper;
import com.kxll.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzq
 * @since 2018-05-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loadUserByUsername(String username) {
        List<User> list = userMapper.loadUserByUsername(username);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }
}
