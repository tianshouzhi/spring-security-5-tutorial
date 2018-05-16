package com.tianshouzhi.security.service;

import com.tianshouzhi.security.entity.PrivilegeEntity;
import com.tianshouzhi.security.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
public class CustomUserDetails implements UserDetails {
	private static String ROLE_PREFIX = "ROLE_";

	private UserEntity delegate;

	private List<GrantedAuthority> authorities = new ArrayList<>();

	public CustomUserDetails(UserEntity delegate, List<PrivilegeEntity> privilegeEntities) {
		this.delegate = delegate;

		if (privilegeEntities != null) {
			for (PrivilegeEntity privilegeEntity : privilegeEntities) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + privilegeEntity.getName());
                this.authorities.add(authority);
			}
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return delegate.getPassword();
	}

	@Override
	public String getUsername() {
		return delegate.getUsername();
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
