/**
 * 
 */
package com.allen.spring.jms.producer.service;

import javax.jms.Destination;

/**
 * @author first
 *
 */
public interface ProducerService {

    public void sendMessage(Destination destination, final String message); 
}
