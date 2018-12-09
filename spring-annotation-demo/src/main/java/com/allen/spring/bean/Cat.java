package com.allen.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by meng on 2018/12/2.
 */
public class Cat implements InitializingBean , DisposableBean {

    public Cat() {
        System.out.println("Cat constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat destory...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat afterProperties...");
    }
}
