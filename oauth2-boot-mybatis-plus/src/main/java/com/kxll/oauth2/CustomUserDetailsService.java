package com.kxll.oauth2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kxll.entity.User;
import com.kxll.entity.UserPrivilege;
import com.kxll.service.IUserPrivilegeService;
import com.kxll.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    IUserService userService;
    @Autowired
    private IUserPrivilegeService userPrivilegeService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.loadUserByUsername(s);
        if (user != null) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("user_id", user.getId());
            List<UserPrivilege> userPrivilegeList = userPrivilegeService.selectByMap(map);
            List<GrantedAuthority> authorities = Lists.newArrayList();
            for (UserPrivilege userPrivilege : userPrivilegeList) {
                authorities.add(new SimpleGrantedAuthority(userPrivilege.getPrivilege()));
            }
            user.setAuthorities(authorities);
            return user;
        }
        return null;
    }
}
