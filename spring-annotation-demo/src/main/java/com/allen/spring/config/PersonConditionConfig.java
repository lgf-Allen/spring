package com.allen.spring.config;

import com.allen.spring.bean.Person;
import com.allen.spring.condition.AliOSCondition;
import com.allen.spring.condition.LinuxCondition;
import com.allen.spring.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by meng on 2018/12/1.
 * @Conditional(ConditionObject.class)
 *      ConditionObject 实现Condition接口，实现match方法，根据条件过滤返回
 */
@Configuration
public class PersonConditionConfig {

    @Conditional(LinuxCondition.class)
    @Bean("linux")
    public Person person01(){
        return new Person("Linux" , 55);
    }

    @Conditional(AliOSCondition.class)
    @Bean("mayun")
    public Person person02(){
        return new Person("Mayun" , 55);
    }

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person03(){
        return new Person("Bill" , 55);
    }
}
