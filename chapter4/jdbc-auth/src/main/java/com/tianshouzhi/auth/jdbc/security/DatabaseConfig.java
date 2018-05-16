package com.tianshouzhi.auth.jdbc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("shxx12151022");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc-auth?characterEncoding=UTF-8");
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        return dataSource;
    }
}
