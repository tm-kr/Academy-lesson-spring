package aop05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop05.xml");

		Person alice = ctx.getBean("proGamer", Person.class);
		Person bob = ctx.getBean("programmer", Person.class);
		
		int useTime = 0;
		useTime = alice.usingComputer("1234");
		System.out.println("alice 사용시간 : " + useTime);
		System.out.println("-------------");
		useTime = bob.usingComputer("5678");
		System.out.println("bob 사용시간 : " + useTime);
	}
}
