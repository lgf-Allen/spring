package com.allen.spring.config;

import com.allen.spring.bean.RRULocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by meng on 2018/12/8.
 * @PropertySource就相当于xml配置中的place-holder
 *          <context:property-placeholder location="rruLocation.properties"></context:property-placeholder>
 * @Value(value):
 *         value可以为一个具体的值，
 *         也可以是一个SPL
 *         也可以去一个文件中获取值
 */
@Configuration
@PropertySource(value = {"classpath:rruLocation.properties"})
public class ValidAndPropertySourceConfig {

    @Bean
    public RRULocation rruLocation(@Value("${rruLocation.name}") String name,
                                   @Value("${rruLocation.sum}") String sum) {
        return new RRULocation(name , sum);
    }

}
