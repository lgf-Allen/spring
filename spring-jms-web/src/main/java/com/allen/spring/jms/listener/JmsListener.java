/**
 * 
 */
package com.allen.spring.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

/**
 * @author first
 *
 */
public class JmsListener implements SessionAwareMessageListener<Message> {

    /**
     * 
     */
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        logger.info("消息内容" + message);
        logger.info("消息JMSID" + message.getJMSMessageID());
        logger.info("消息JMSCorrelationID" + message.getJMSCorrelationID());
        logger.info("消息Test" + ((TextMessage) message).getText());
        
    }

}
