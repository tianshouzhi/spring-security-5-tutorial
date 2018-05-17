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

		auth.inMemoryAuthentication().withUser(user).passwordEncoder(encoder);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//访问静态资源不需要安全保护
		web.ignoring()
				.antMatchers("/bower_components/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 访问index.html不要权限验证
                .antMatchers("/index.html").permitAll()
				// 其他所有路径都需要权限校验 ，顺序很重要，第一次匹配上的即通过
				.anyRequest().authenticated()
				.and()
				// 配置表单登录
		      .formLogin()
				  // 表单登录页面地址
		     	 .loginPage("/login.jsp")
				  // form表单POST请求url提交地址，默认为/login
		     	 .loginProcessingUrl("/login")
				  // form表单用户名参数名
		     	 .passwordParameter("password")
				  // form表单密码参数名
		     	 .usernameParameter("username")
				  // 登录成功跳转地址
//				  .successForwardUrl("/success.html")
				  // 登录失败跳转地址
//                  .failureForwardUrl("/error.html")
//				.mappingFailureHandler(mappingFailureHandler());
				  // 登录成功默认的跳转页面
				 .defaultSuccessUrl("/index.html")
				  //允许所有用户都有权限访问登录页面
				 .permitAll();

	}
}
