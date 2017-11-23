/**
 * 
 */
package com.allen.spring.jms.producer.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.allen.spring.jms.producer.service.ProducerService;

/**
 * @author first
 *
 */
@Component
public class ProducerServiceImpl implements ProducerService {
    
    @Autowired
    @Qualifier("jms/replyQueue")
    private Destination replyQueue;
    
    private JmsTemplate jmsTemplate;
    @Override
    public void sendMessage(Destination destination, final String message) {
        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);
        
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMsg = session.createTextMessage(message);
                textMsg.setJMSReplyTo(replyQueue);
                textMsg.setJMSMessageID("requestId------");
                return session.createTextMessage(message);
            }
        });
    } 

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    } 

    @Resource
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
