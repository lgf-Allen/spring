package com.allen.spring.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器:bean初始化前后工作
 * Created by meng on 2018/12/2.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization ....beanName -->" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization ... beanName ---> " + beanName);
        return bean;
    }

}
