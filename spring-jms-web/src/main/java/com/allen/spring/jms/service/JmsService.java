/**
 * 
 */
package com.allen.spring.jms.service;

import javax.jms.JMSException;

/**
 * @author first
 *
 */
public interface JmsService {

    /**
     * 
     * @param message
     * @return
     * @throws JMSException 
     */
    String sendAndReceive(String message) throws JMSException;
}
