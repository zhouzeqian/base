package com.llc.shiro;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.beust.jcommander.internal.Sets;
import com.google.common.collect.Lists;
import com.llc.entity.Permission;
import com.llc.entity.Role;
import com.llc.entity.User;
import com.llc.service.UserService;

@Component
public class MyRealm extends AuthorizingRealm {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	UserService userService;
	@Resource
	SessionDAO sessionDAO;

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
			// apache shiro获取所有在线用户
			// 只允许一个账户登录
			// 处理session
			Collection<Session> sessions = sessionDAO.getActiveSessions();// 获取当前已登录的用户session列表
			for (Session session : sessions) {
				String loginUsername = String
						.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));// 获得session中已经登录用户的名字
				log.info("在线用户:" + loginUsername + "  " + session.getId());
				log.info("当前登录用户:"+user.getUsername()+"   "+SecurityUtils.getSubject().getSession().getId());
				// 2种处理
				if (user.getUsername().equals(loginUsername)) { // 这里的username也就是当前登录的username
					
					if(!session.getId().equals(SecurityUtils.getSubject().getSession().getId())) {
					log.info("该帐号已登录");
					// sessionDAO.delete(session); // 1.清理已登录的session,已后面登录为准
					throw new ConcurrentAccessException("该帐号已登录");// 2.抛出已登录的异常,已已经登录的为准
					}
				}
			}

			// 保存用户登录信息到认证中
			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		}
		return null;
	}

}