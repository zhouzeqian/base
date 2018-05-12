package com.kxll.controller;

import com.kxll.Service.UserService;
import com.kxll.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("find")
    @ResponseBody
    public User find(Long id){
        return userService.find(id);

    }
}
