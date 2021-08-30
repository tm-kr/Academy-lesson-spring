package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client;
import spring.Client2;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		Client client = ctx.getBean("client", Client.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		client.send();
		client2.send();
		
		ctx.close();
	}
}
