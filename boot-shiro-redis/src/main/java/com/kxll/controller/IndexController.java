package com.kxll.controller;

import com.kxll.Service.UserService;
import com.kxll.entity.User;
import com.kxll.util.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @RequestMapping(value="login",method =RequestMethod.POST )
    public String login(String username, String password) {
    	ModelAndView mav=new ModelAndView();
        String errorMsg=null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, EncryptUtil.MD5(password));
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            errorMsg="密码错误";
            mav.addObject("errorMsg",errorMsg);
             return  "login";
        } catch (LockedAccountException e) {
            errorMsg="登录失败，该用户已被冻结";
            mav.addObject("errorMsg",errorMsg);
              return  "login";
        } catch (AuthenticationException e) {
            errorMsg="该用户不存在";
            mav.addObject("errorMsg",errorMsg);
              return  "login";
        } catch (Exception e) {
        	errorMsg="未知错误";
            mav.addObject("errorMsg",errorMsg);
            return  "login";
        }
        mav.addObject("user", (User)subject.getPrincipal());
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String index() {
        return "login";
    }


}
