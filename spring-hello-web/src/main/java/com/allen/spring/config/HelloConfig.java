/**
 * 
 */
package com.allen.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.allen.spring.controller.Female;

/**
 * @author first
 *
 */
@Configuration
public class HelloConfig {

    @Bean
    public Female female(){
        return new Female("张三","男");
    }
}
