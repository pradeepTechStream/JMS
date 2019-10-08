package com.jms.test;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component("messageSender")
public class MessageReceiver implements MessageListener {

    @Override
    public void onMessage(Message m) {
	TextMessage message = (TextMessage) m;
	try {
	    System.out.println("Recieved:"+message.getText());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
