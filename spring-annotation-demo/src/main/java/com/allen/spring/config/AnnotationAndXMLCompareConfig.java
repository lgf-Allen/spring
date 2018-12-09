package com.allen.spring.config;

import com.allen.spring.custom.MyTypeFilter;
import com.allen.spring.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * Created by meng on 2018/12/1.
 *
 * 声明bean：
 *  XML声明bean：classpath:beans.xml声明的person bean
 *  Annotation 声明bean：@Bean, @Controller, @RestController, @Servcie, @Component, @Configuration
 *
 * 扫描包
 *  XML:<context:component-scan base-package="com.allen.spring.component"/>
 *  @ComponentScan()
 *  @ComponentScans()
 *
 * Spring bean默认是Singleton, 通过@Scope可以修改bean加载模式,支持以下四种方式：
 *      @see ConfigurableBeanFactory#SCOPE_PROTOTYPE 多实例模式
 *      @see ConfigurableBeanFactory#SCOPE_SINGLETON 单实例模式
 *      @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST 同一次请求创建一个实例
 *      @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION 同一个session创建一个实例
 * @Lazy 只能作用在@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON),默认情况下bean在IoC容器启动的时候创建对象
 *
 *
 *
 */
@Configuration
@ComponentScan(value = "com.allen.spring.bean.filter" , excludeFilters =
        // FilterType.ASSIGNABLE_TYPE:指定类型
        //@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        //        classes = {PersonService.class}),

        // FilterType.ANNOTATION:指定注解类型
        //@ComponentScan.Filter(type = FilterType.ANNOTATION ,
        //        classes = {Controller.class}),

        // FilterType.CUSTOM:自定义过滤规则
        @ComponentScan.Filter(type = FilterType.CUSTOM ,
        classes = {MyTypeFilter.class}))
public class AnnotationAndXMLCompareConfig {

    //@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //@Lazy
    @Bean
    public Person person(){
        // Singleton mode and lazy , IoC container不创建对象，在第一次调用创建
        System.out.println("使用注解往IoC容器添加Person bean...");
        return new Person("Wangwu" , 18);
    }
}
