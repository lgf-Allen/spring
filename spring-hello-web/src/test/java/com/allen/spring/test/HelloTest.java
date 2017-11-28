/**
 * 
 */
package com.allen.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allen.spring.config.HelloConfig;
import com.allen.spring.controller.Female;

/**
 * @author first
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloConfig.class)
public class HelloTest {

    ApplicationContext context;
    @Test
    public void getBean(){
        
        context = new AnnotationConfigApplicationContext();
        Female female = context.getBean(Female.class);
        System.out.println(female.getName());
    }
}
