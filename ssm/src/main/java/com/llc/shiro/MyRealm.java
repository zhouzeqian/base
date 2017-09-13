package com.llc.shiro;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.beust.jcommander.internal.Sets;
import com.google.common.collect.Lists;
import com.llc.entity.Permission;
import com.llc.entity.Role;
import com.llc.entity.User;
import com.llc.service.UserService;

@Component
public class MyRealm extends AuthorizingRealm {
	@Resource
	UserService userService;

	/**
	 * 权限认证，获取登录用户的权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
		// 此处连库匹配了登录用户的数据，具体怎么做，需要根据个人需求而定
		User user = userService.findByName(loginName);
		if (user != null) {
			List<Role> list = userService.findByUserId(user.getId());
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 获取用户的角色名称和用户的权限
			if (list != null && list.size() > 0) {
				Set<String> roleNames = Sets.newHashSet();
				List<String> PermissionNames = Lists.newArrayList();
				for (Role role : list) {
					roleNames.add(role.getRoleName());
					List<Permission> PermissionList = userService.findByRoleId(role.getId());
					if (PermissionList != null && PermissionList.size() > 0) {
						for (Permission permission : PermissionList) {
							PermissionNames.add(permission.getPermissionName());
						}
					}
				}
				info.setRoles(roleNames);
				info.addStringPermissions(PermissionNames);
			}
			return info;
		}
		return null;
	}

	/**
	 * 登录认证，创建用户的登录信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		// 判断用户登录状态
		User user = userService.findByName(token.getUsername());
		if (user != null) {
			// 保存用户登录信息到认证中
			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		}
		return null;
	}

}