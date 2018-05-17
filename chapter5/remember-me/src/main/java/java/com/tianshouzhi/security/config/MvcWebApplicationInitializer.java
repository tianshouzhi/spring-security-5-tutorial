package java.com.tianshouzhi.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by tianshouzhi on 2018/5/14.
 */
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {//根容器
        return new Class<?>[] { RootConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//Spring mvc容器
        return new Class<?>[] { WebConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {//DispatcherServlet映射,从"/"开始
        return new String[] { "/" };
    }
}
