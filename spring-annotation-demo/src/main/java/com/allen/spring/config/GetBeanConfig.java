package com.allen.spring.config;

import com.allen.spring.bean.BeanService;
import com.allen.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by meng on 2018/12/8.
 * 自动装配：
 *      Spring         @Autowired 默认优先按照类型去容器中寻找对应组件;
 *                      如果有多个，会按照id去匹配;还可以使用@Qualifier指定id;
 *                      支持@Primary,还支持required配置，
 *
 *      JSR 250        @Resource，默认按照组件名称匹配，不支持@Qualifier,@Primary,required=false
 *      JSR 330        @Inject,支持@Primary,不支持required=false
 */
@Configuration
@Import(BeanService.class)
public class GetBeanConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
