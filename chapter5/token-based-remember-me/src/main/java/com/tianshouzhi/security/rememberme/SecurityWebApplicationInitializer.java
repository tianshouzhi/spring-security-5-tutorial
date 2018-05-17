package com.tianshouzhi.security.rememberme;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebApplicationInitializer() {
        super(SecurityConfiguration.class);
    }
}
