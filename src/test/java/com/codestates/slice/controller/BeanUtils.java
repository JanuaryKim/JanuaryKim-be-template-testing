package com.codestates.slice.controller;

import org.springframework.context.ApplicationContext;

public class BeanUtils {

    static ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();

    public static Object getBean(String beanId) {

        if( applicationContext == null ) {
            throw new NullPointerException("Spring의 ApplicationContext초기화 안됨");
        }

        return applicationContext.getBean(beanId);
    }

    public static String[] getDefinitionNames() {

        return applicationContext.getBeanDefinitionNames();
    }
}
