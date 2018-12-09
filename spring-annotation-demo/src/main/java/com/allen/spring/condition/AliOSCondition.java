package com.allen.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by meng on 2018/12/1.
 */
public class AliOSCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
        // 当操作系统为AliOS时，条件满足
        if(osName.contains("AliOS")){
            return true;
        }
        return false;
    }
}
