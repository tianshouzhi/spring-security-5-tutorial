package com.tianshouzhi.security.config.database;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
@Configuration
@MapperScan(basePackages = "com.tianshouzhi.security.mapper")
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("shxx12151022");
        dataSource.setUrl("jdbc:mysql://localhost:3306/custom-auth?characterEncoding=UTF-8");
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        return dataSource;
    }

    @Autowired
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource);
        return ssfb;
    }
}
