package com.tianshouzhi.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
public class UserEntity implements Serializable{
	private int id;

	private String username;

	private String password;

	private int age;

	private Date birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
