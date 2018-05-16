package com.tianshouzhi.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by tianshouzhi on 2018/5/14.
 */
@Configuration
@Import(SecurityConfiguration.class)
public class RootConfiguration {

}
