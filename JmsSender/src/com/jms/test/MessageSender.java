package com.jms.test;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("messageSender")
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
	jmsTemplate.send(new MessageCreator() {

	    @Override
	    public Message createMessage(Session session) throws JMSException {
		return session.createTextMessage(message);
	    }
	});
    }

}
