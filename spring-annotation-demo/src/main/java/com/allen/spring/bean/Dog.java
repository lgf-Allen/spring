package com.allen.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by meng on 2018/12/2.
 */
public class Dog {

    public Dog() {
        System.out.println("Dog constructor ...");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog postConstruct...");
    }

    @PreDestroy
    public void destory() {
        System.out.println("Dog preDestory...");
    }
}
