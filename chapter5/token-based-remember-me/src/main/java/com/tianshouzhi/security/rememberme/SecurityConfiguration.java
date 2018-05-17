package com.tianshouzhi.security.rememberme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		UserDetails user = User.builder()
				.passwordEncoder(encoder::encode)
				.username("tianshouzhi")
				.password("tianshouzhi123")
				.roles("USER")
				.build();

		auth.inMemoryAuthentication().withUser(user);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//访问静态资源不需要安全保护
		web.ignoring()
				.antMatchers("/bower_components/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.anyRequest().authenticated()
				.and()
		      		.formLogin()
		     	 	.loginPage("/login.jsp")
				 	.permitAll();

	}
}
