/**
 * 
 */
package com.allen.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${response.name}")
    private String name;
    @Value("${response.message}")
    private String message;
    @RequestMapping(path="/welcome")
    public Response hello(){
        Response r = new Response(name,message);
        return r;
    }
}
