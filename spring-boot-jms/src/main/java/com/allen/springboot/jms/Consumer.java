/**
 * 
 */
package com.allen.springboot.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author first
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
        return new ActiveMQQueue("replyQueue");
    }
    @Override
    @JmsListener(destination = "requestQueue")
    public void onMessage(Message message, Session session) throws JMSException {
        consumer = (ActiveMQQueue) queue();
        MessageProducer producer = session.createProducer(consumer);
        String result = ((TextMessage) message).getText();
        System.out.println("response"+result);
        Message messagess = session.createTextMessage(result);
        messagess.setJMSCorrelationID(message.getJMSMessageID());
        System.out.println(message.getJMSMessageID());
        messagess.setJMSMessageID(message.getJMSMessageID());
        producer.send(messagess);
        System.out.println("消息发送成功。。。。");
    }

}
