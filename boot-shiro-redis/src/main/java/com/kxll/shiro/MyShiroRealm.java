package com.kxll.shiro;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.kxll.Service.UserService;
import com.kxll.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;
    @Autowired
    SessionDAO sessionDAO;
    @Autowired
    RedissonClient redissonClient;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        // 从数据库获取对应用户名密码的用户
        User user = userService.findByUserName(name);
        if (user != null) {
            // 用户为禁用状态
            if (user.getArchived()) {
                throw new DisabledAccountException();
            }
            logger.info("---------------- Shiro 凭证认证成功 ----------------------");
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user, //用户
                    user.getPassword(), //密码
                    getName()  //realm name
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof User) {
            User userLogin = (User) principal;
            List<Map<String, Object>> roleList = userService.findRoles(userLogin.getId());
            Set<String> roles = Sets.newHashSet();
            List<String> permissions = Lists.newArrayList();
            if (roleList != null && roleList.size() > 0) {
                for (Map<String, Object> role : roleList) {
                    roles.add(role.get("role_name").toString());
                    permissions.addAll(userService.findPermissions(Long.valueOf(role.get("id").toString())));
                }
                authorizationInfo.addRoles(roles);
                authorizationInfo.addStringPermissions(permissions);
            }

        }
        return authorizationInfo;
    }
}
