package com.practice;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {

    public void sendMessage() {
	ConnectionFactory factory = null;
	Connection connection = null;
	Session session = null;
	Destination destination = null;
	MessageProducer producer = null;

	try {
	    factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
	    connection = factory.createConnection();
	    connection.start();
	    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    destination = session.createQueue("SAMPLEQUEUE");
	    producer = session.createProducer(destination);
	    TextMessage message = session.createTextMessage();
	    message.setText("Hello ...This is a sample message.sending from Client");
	    producer.send(message);
	    System.out.println("Sent: " + message.getText());

	} catch (JMSException e) {
	    e.printStackTrace();
	}
    }  

}
