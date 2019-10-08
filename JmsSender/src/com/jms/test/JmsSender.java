package com.jms.test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JmsSender {

    public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:applicationContext.xml");
	ctx.refresh();

	MessageSender sender = ctx.getBean("messageSender", MessageSender.class);
	sender.sendMessage("This Message to send");
	System.out.println("added to queue refresh screen");
    }

}
