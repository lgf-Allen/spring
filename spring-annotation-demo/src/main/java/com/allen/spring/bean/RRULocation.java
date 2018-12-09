package com.allen.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * Created by meng on 2018/12/8.
 */
public class RRULocation implements ApplicationContextAware , EmbeddedValueResolverAware {

    private String name;

    private String sum;

    private ApplicationContext applicationContext;

    private StringValueResolver resolver;

    public RRULocation(String name, String sum) {
        this.name = name;
        this.sum = sum;
        System.out.println("RRULocation construct ...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        RRULocation rruLocation = applicationContext.getBean(RRULocation.class);
        System.out.println("rruLocation name is ---> " + rruLocation.getName());
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        String sum = resolver.resolveStringValue("${rruLocation.sum}");
        System.out.println("RRULocation sum is ---->" + sum);
    }
}
