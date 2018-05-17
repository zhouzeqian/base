package com.kxll.service;

import com.baomidou.mybatisplus.service.IService;
import com.kxll.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zzq
 * @since 2018-05-14
 */
public interface IUserService extends IService<User> {
    User loadUserByUsername(String username);
	
}
