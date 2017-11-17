/**
 * 
 */
package com.allen.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(path="/welcome")
    public Response hello(){
        return new Response("测试","reponse");
    }
}
