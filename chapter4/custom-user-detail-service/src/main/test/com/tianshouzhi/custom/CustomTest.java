package com.tianshouzhi.custom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshouzhi.security.config.database.DatabaseConfig;
import com.tianshouzhi.security.entity.PrivilegeEntity;
import com.tianshouzhi.security.entity.UserEntity;
import com.tianshouzhi.security.mapper.PrivilegeMapper;
import com.tianshouzhi.security.mapper.UserMapper;
import com.tianshouzhi.security.service.MD5PasswordEncoder;

import java.util.Date;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class CustomTest {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PrivilegeMapper privilegeMapper;

	private PasswordEncoder passwordEncoder=new MD5PasswordEncoder();

	@Test
	public void testInsert() {
		UserEntity user = new UserEntity();
		user.setUsername("tianshouzhi");
		user.setPassword(passwordEncoder.encode("tianshouzhi123"));
		user.setAge(30);
		user.setBirthday(new Date());
		userMapper.insert(user);

		PrivilegeEntity privilege = new PrivilegeEntity();
		privilege.setUserId(user.getId());
		privilege.setName("USER");
		privilegeMapper.insert(privilege);
	}
}
