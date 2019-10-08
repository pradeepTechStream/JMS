package com.jms.test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JmsReceiver {

    public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:applicationContext.xml");
	ctx.refresh();
    }

}
