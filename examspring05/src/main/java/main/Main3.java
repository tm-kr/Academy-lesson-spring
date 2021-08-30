package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import conf.JavaConfigPrototype;
import spring.Client;
import spring.Client2;

public class Main3 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		
		Client client = ctx.getBean("client", Client.class);
		Client client2 = ctx.getBean("client", Client.class);
		
		client.send();
		client2.send();
		
		Client2 client3 = ctx.getBean("client2", Client2.class);
		Client2 client4 = ctx.getBean("client2", Client2.class);
		
		client3.send();
		client4.send();
		
		ctx.close();
		
		//스프링 컨테이너가 관리하지 않는 bean이므로 직접 소멸관련 처리
		try {
			client.destroy();
			client2.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
