package com.tianshouzhi.auth.jdbc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by tianshouzhi on 2017/12/18.
 */
@EnableWebSecurity(debug = true)
@Import(DatabaseConfig.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDetails user = User.builder()
                .passwordEncoder(encoder::encode)
                .username("tianshouzhi")
                .password("tianshouzhi123")
                .roles("USER")
                .build();

        auth
                .jdbcAuthentication()
                    //1、设置数据源
                    .dataSource(dataSource)
                   /* 2、withDefaultSchema执行org.springframework.security.core.userdetails.jdbc. users.ddl建表语句，
                     语法仅适用于HSQLDB，由于案例使用的是mysql，且已经手工在数据库中创建过users表和authorities表，不需要执行这个方法*/
                    // .withDefaultSchema()
                    //3、根据用户名查询用户信息的sql，默认为JdbcDaoImpl.DEF_USERS_BY_USERNAME_QUERY
                    //7、在数据库启动时，创建一下用户, 注意每次启动都会创建，重复创建会报错
                    //.withUser(user)
                    .usersByUsernameQuery(JdbcDaoImpl.DEF_USERS_BY_USERNAME_QUERY)
                    //4、密码加密器，新增用户保存到数据库的时候，会对密码进行加密。
                    .passwordEncoder(encoder)
                    //5、根据用户名查询用户权限的sql,默认为JdbcDaoImpl.DEF_AUTHORITIES_BY_USERNAME_QUERY
                    .authoritiesByUsernameQuery(JdbcDaoImpl.DEF_AUTHORITIES_BY_USERNAME_QUERY)
                    //6、角色的前缀，默认为空字符串""，如果数据库中的角色已经包含了"ROLE_"前缀，则这里不需要指定，否则需要加上ROLE_前缀
                    .rolePrefix("")

                     .passwordEncoder(encoder)
                     //9、用户信息缓存，避免每次都查询数据库，默认为NullUserCache
                    .userCache(new NullUserCache());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/bower_components/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/privilege.html").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.jsp")
                .loginProcessingUrl("/login")
                .passwordParameter("password")
                .usernameParameter("username")
                .defaultSuccessUrl("/index.html")
                .permitAll();
    }
}
