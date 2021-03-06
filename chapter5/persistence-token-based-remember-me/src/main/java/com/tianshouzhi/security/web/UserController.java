package com.tianshouzhi.security.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tianshouzhi.security.config.security.CustomUserDetails;

/**
 * Created by tianshouzhi on 2018/5/14.
 */
@RestController
public class UserController {
	@GetMapping("/user")
	public UserDetails user() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
		return principal;
	}
}
