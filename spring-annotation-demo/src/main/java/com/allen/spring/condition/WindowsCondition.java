package com.allen.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by meng on 2018/12/1.
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // Obtains IoC beanFacotry
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // Obtains ClassLoader
        ClassLoader classLoader = context.getClassLoader();
        // Obtains BeanDefinitionRegistry
        BeanDefinitionRegistry registry = context.getRegistry();
        // Obtains Environment
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
        // 当操作系统为Windows时，条件满足
        if (osName.contains("Windows")) {
            return true;
        }
        return false;
    }
}
