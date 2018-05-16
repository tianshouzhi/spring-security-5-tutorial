package com.tianshouzhi.security.formlogin;

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
		String key = "remember-me";
		http.authorizeRequests()
                .antMatchers("/index.html").permitAll()
			    .antMatchers("/privilege.html").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()
				.and()
		      .formLogin()
		     	 .loginPage("/login.jsp")
		     	 .loginProcessingUrl("/login")
		     	 .passwordParameter("password")
		     	 .usernameParameter("username")
				 .defaultSuccessUrl("/index.html")
				 .permitAll()
		    .and()
				.rememberMe()
				.rememberMeParameter("remember-me") //1
				.rememberMeCookieName("remember-me") //2
				.rememberMeCookieDomain(null) //3
				.tokenValiditySeconds(1209600) //4
				.alwaysRemember(false) //5
				.useSecureCookie(true)  //6
//				.tokenRepository(new TokenBasedRememberMeServices(key,))
				.key(key); //7

	}
}
