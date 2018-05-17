package com.kxll.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kxll.entity.User;
import com.kxll.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author zzq
 * @since 2018-05-14
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    IUserService userService;

	@RequestMapping("findById")
    public User findById(Long id){
        return  userService.selectById(id);
    }

    @RequestMapping("findByUser")
    public User findByUser(User user){
        return  userService.selectOne(new EntityWrapper<User>(user));
    }

    @RequestMapping("page")
    public Page<User> page(){
        return  userService.selectPage(new Page<User>(0,10));
    }
}
