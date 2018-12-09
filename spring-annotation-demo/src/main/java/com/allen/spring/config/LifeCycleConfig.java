package com.allen.spring.config;

import com.allen.spring.custom.MyBeanPostProcessor;
import com.allen.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * bean的生命周期：
 *      bean创建-->初始化-->销毁的过程
 * 容器管理bean的生命周期：
 * 1.指定初始化和销毁方法
 *      单实例情况下，容器启动时就会创建spring bean，并调用初始化方法
 *      在容器关闭时调用spring bean的销毁方法
 *      多实例情况下，容器启动时不会创建spring bean,也不会调用初始化方法
 *      容器关闭时，不会调用spring bean销毁方法，需要手动调用destory方法
 * 2. 通过bean实现InitializingBean初始化bean
 *            实现DisposableBean销毁bean
 * 3. 使用JSR250
 *         @PostConstruct , 在bean创建完成并且赋值完成后，来执行初始化方法
 *         @PreDestroy ,在容器销毁bean之前执行清理工作
 * 4. BeanPostProcessor【interface】：bean的后置处理器
 *         在bean初始化前后进行一些处理工作：
 *         postProcessBeforeInitialization:在初始化之前工作
 *         postProcessAfterInitialization：在初始化之后工作
 *
 * populateBean(beanName, mbd, instanceWrapper):给bean属性赋值
 *
 * initializeBean{
 * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName): 遍历得到容器中所有的BeanPostProcessor,挨个执行postProcessBeforeInitialization
 * 一旦返回null,跳出for循环,不会执行后面的postProcessBeforeInitialization
 *
 * invokeInitMethods(beanName, wrappedBean, mbd):执行初始化
 *
 * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName): 遍历得到容器中所有的BeanPostProcessor,挨个执行postProcessAfterInitialization
 * 一旦返回null,跳出for循环,不会执行后面的postProcessAfterInitialization
 *}
 *
 * Spring底层实现了对BeanPostProcessor的广泛应用
 *          bean赋值，@Autowired
 *          @Bean(initMethod = "init" , destroyMethod = "destory")
 *          @Asyc
 *
 * Created by meng on 2018/12/2.
 */
@Configuration
@Import(MyBeanPostProcessor.class)
public class LifeCycleConfig {

    //@Scope("prototype")
    @Bean(initMethod = "init" , destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

    //@Bean
    //public Cat cat(){
    //    return new Cat();
    //}
    //
    //@Bean
    //public Dog dog(){
    //    return new Dog();
    //}

}
