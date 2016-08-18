package com.andries.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Andries on 8/17/16.
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringRootConfig.class};
    }

    @Override protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringWebConfig.class};
    }

    @Override protected String[] getServletMappings() {
        return new String[]{"/api/*"};
    }
}
