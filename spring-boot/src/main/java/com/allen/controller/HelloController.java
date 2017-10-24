/**
 * 
 */
package com.allen.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author first
 *
 */
@Controller
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping(value="/hello.html")
    @ResponseBody
    public String hello(){
        return "Hello";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloController.class, args);
    }
}
