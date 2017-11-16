/**
 * 
 */
package com.allen.spring.jms.controller.impl;

import java.util.Date;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allen.spring.jms.service.JmsService;
import com.allen.spring.jms.service.impl.JmsServiceImpl;
import com.allen.spring.jms.vo.Response;

/**
 * @author first
 *
 */
@RequestMapping("/hello")
@RestController
public class JmsControllerImpl {

    @Autowired
    private JmsService jmsService;
    
    @RequestMapping(path="/login",method=RequestMethod.GET)
    public Response hello() throws JMSException{
        Response r = new Response();
        r.setName("Lisi");
        r.setDate(new Date(System.currentTimeMillis()));
        jmsService.sendAndReceive(r.toString());
        return r;
    }
}
