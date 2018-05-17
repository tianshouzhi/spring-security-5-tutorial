package com.tianshouzhi.security.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 * Created by tianshouzhi on 2018/5/17.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(
                        User.withDefaultPasswordEncoder()
                                .username("tianshouzhi")
                                .password("tianshouzhi123")
                                .roles("USER"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bower_components/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                .and()
                    .csrf().disable()
                 .formLogin()
                    .loginProcessingUrl("/login")
                    .loginPage("/login")
                    .permitAll();
    }
}
