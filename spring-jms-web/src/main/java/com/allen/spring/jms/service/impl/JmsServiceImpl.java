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

import com.allen.spring.jms.service.JmsService;

/**
 * @author first
 *
 */
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
    
    /* (non-Javadoc)
     * @see com.allen.spring.jms.service.JmsService#sendAndReceive(java.lang.String)
     */
    @Override
    public String sendAndReceive(final String message) throws JMSException {
        final String identificationId = "jms-" + String.valueOf(System.currentTimeMillis())
        + String.valueOf(count.getAndIncrement());
        logger.debug("method:"+"request");
        jmsTemplate.send(requestQueue, new MessageCreator() {
            
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg = session.createTextMessage(message);
                //msg.setJMSReplyTo(replyQueue);
                msg.setJMSCorrelationID(identificationId);
                ts.set(msg);
                return msg;
            }
        });
        
        String messageId = ts.get().getJMSMessageID();
        javax.jms.TextMessage jms = (TextMessage) jmsTemplate.receiveSelected(replyQueue,
                "JMSCorrelationID" + "=" + "'" + messageId + "'");
        if (jms != null) {
          logger.debug("method", "response");
          logger.debug(jms.getText());
        } else {
            throw new JMSException("messageID not match");
        }
        return jms.getText();
    }

}
