package com.allen.spring.jms;

import java.io.InputStream;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 
 * @author wang
 *
 */
@Component
public class Consumer implements SessionAwareMessageListener<Message> {

    /**
     * 
     */
    private ActiveMQQueue consumer;

    /**
     * 
     * @return queue
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("replyQueue2");
    }

   
  
    
    @Override
    @JmsListener(destination = "jms/replyQueue")
    public void onMessage(Message message, Session session) throws JMSException {

        consumer = (ActiveMQQueue) queue();
        System.out.println("*****" + consumer);
        MessageProducer producer = session.createProducer(consumer);
        System.out.println("request"+((TextMessage) message).getText());
        String result = ((TextMessage) message).getText();
        Message messagess = session.createTextMessage(result);
        System.out.println("JMSMessageID:"+message.getJMSMessageID());
        messagess.setJMSMessageID(message.getJMSMessageID());
        producer.send(messagess);
    }
}
