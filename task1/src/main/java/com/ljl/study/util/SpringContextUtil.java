package com.ljl.study.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** 
* @author alin 
* @version 2017年6月8日
* 类说明 
*/
public class SpringContextUtil implements ApplicationContextAware {
    
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        applicationContext = ac;

    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
    
    public static boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }

}