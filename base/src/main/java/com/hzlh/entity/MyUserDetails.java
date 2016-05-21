package com.hzlh.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hzlh.enums.Privilege;

public class MyUserDetails implements UserDetails{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4333411249470152910L;
	protected static final String ROLE_PREFIX = "ROLE_";
    protected static final GrantedAuthority DEFAULT_USER_ROLE = new SimpleGrantedAuthority(ROLE_PREFIX + Privilege.USER.name());
	
	boolean status = false;

	private User user;
	
	protected List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	 
	public MyUserDetails() {
	}

	
    public MyUserDetails(User user) {
        this.user = user;
        initialAuthorities();
    }

    private void initialAuthorities() {
    	//Default, everyone have it
        this.grantedAuthorities.add(DEFAULT_USER_ROLE);
        //default user have all privileges
        if (user.defaultUser()) {
            this.grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + Privilege.UNITY.name()));
            this.grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + Privilege.MOBILE.name()));
        } else {
            final List<Privilege> privileges = user.privileges();
            for (Privilege privilege : privileges) {
                this.grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + privilege.name()));
            }
        }
    }
	
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}


	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
