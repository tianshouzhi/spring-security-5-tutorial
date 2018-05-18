package com.tianshouzhi.security.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by tianshouzhi on 2018/5/14.
 */
@EnableWebMvc
@ComponentScan("com.tianshouzhi.security.web")
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        registry.enableContentNegotiation(new MappingJackson2JsonView());//配置JSON视图解析器
        registry.jsp()//配置JSP视图解析器
                .prefix("/WEB-INF/jsp/")
                .suffix(".jsp")
                .viewClass(JstlView.class);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); //配置静态文件处理
    }
}
