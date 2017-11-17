/**
 * 
 */
package com.allen.spring.jms.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.allen.spring.jms.service.JmsService;

/**
 * @author first
 *
 */
@Component
public class JmsServiceImpl implements JmsService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("jms/requestQueue")
    private Destination requestQueue;

    @Autowired
    @Qualifier("jms/replyQueue")
    private Destination replyQueue;

    private AtomicInteger count = new AtomicInteger(0);
    private ThreadLocal<javax.jms.Message> ts = new ThreadLocal<javax.jms.Message>();
    private Logger logger = LoggerFactory.getLogger(getClass());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.allen.spring.jms.service.JmsService#sendAndReceive(java.lang.String)
     */
    @Override
    public String sendAndReceive(final String message) throws JMSException {
        final String identificationId = "jms-" + String.valueOf(System.currentTimeMillis())
                + String.valueOf(count.getAndIncrement());
        logger.debug("method:" + "request");
        logger.debug("开始发送消息");
        jmsTemplate.send(requestQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg = session.createTextMessage(message);
                // 手动标识correlationID的value
                msg.setJMSMessageID(identificationId);
                msg.setJMSCorrelationID(identificationId);
                //将消息放入到当前线程
                ts.set(msg);
                logger.debug("JMSCorrelationID:" + msg.getJMSCorrelationID());
                logger.debug("send message content:" + msg);
                logger.debug("JMS消息发送成功。。。。。。");
                logger.debug(msg.getText());
                return msg;
            }
        });

        String JMSCorrelationID = ts.get().getJMSCorrelationID();
        logger.debug("开始接收消息");
        TextMessage jms = (TextMessage) jmsTemplate.receiveSelected(replyQueue,
                "correlationID" + "=" + JMSCorrelationID);
        if (jms != null) {
            logger.debug("正确找到刚才发出的消息。。。。。。。");
            logger.debug("method", "response");
        } else {
            throw new JMSException("messageID not match");
        }
        logger.debug("JMS消息接收成功。。。。。。。。");
        return jms.getText();
    }

}
