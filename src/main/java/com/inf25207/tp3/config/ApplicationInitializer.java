package com.inf25207.tp3.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author de référence Ramesh Fadatare
 * @author Bastien Goulet
 * Source: https://www.javaguides.net/2018/11/spring-5-hibernate-5-java-config-example.html
 */

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class <?> [] getRootConfigClasses() {
        return new Class[] {
                ApplicationContext.class
        };
        //return null;
    }

    @Override
    protected Class <?> [] getServletConfigClasses() {
        return new Class[] {
                WebMvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/"
        };
    }
}