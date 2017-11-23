/**
 * 
 */
package com.spring.jms.test;

import java.io.IOException;
import java.io.InputStream;

import javax.jms.Destination;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allen.spring.jms.producer.service.ProducerService;

/**
 * @author first
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:web-application.xml"})
public class JmsTest {

    @Autowired
    private ProducerService producerService;
    @Autowired
    @Qualifier("jms/requestQueue")
    private Destination requestQueue;
    
//    @Autowired
//    @Qualifier("jms/requestQueue")
//    private Destination requestQueue;
    
    @Test
    public void jmsClient() throws IOException{
//        Resource resource=null;
//        InputStream stream=null;
//        resource=new ClassPathResource("template/exist.xml");
//        stream=resource.getInputStream();
//        String result = new String(IOUtils.toByteArray(stream));
        producerService.sendMessage(requestQueue, "This is a test jms message.");
    }
    
}
