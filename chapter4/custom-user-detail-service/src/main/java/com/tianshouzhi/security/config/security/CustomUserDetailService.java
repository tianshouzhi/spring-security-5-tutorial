package com.tianshouzhi.security.config.security;

import com.tianshouzhi.security.entity.PrivilegeEntity;
import com.tianshouzhi.security.entity.UserEntity;
import com.tianshouzhi.security.mapper.PrivilegeMapper;
import com.tianshouzhi.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tianshouzhi on 2018/5/15.
 */

@Component
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PrivilegeMapper privilegeMapper;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		UserEntity user = userMapper.loadUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		List<PrivilegeEntity> privileges = privilegeMapper.loadByUserId(user.getId());

		return new CustomUserDetails(user, privileges);
	}
}
