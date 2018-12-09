package com.allen.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by meng on 2018/12/1.
 */
public class ColorFactoryBean implements FactoryBean<Color>{
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
