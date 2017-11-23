/**
 * 
 */
package com.allen.spring.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author first
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(path="/findAll",method=RequestMethod.GET)
    @ResponseBody
    public List<Female> findAll(){
        System.out.println("receive request.");
        List<Female> list = new LinkedList<Female>();
        Female f1 = new Female("张三", "男");
        Female f2 = new Female("李四","男");
        list.add(f1);
        list.add(f2);
        System.out.println("send response.");
        return list;
    }
}
