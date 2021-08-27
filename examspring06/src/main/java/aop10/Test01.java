package aop10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop09.Person;

public class Test01 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop10.xml");

		Person alice = ctx.getBean("proGamer", Person.class);
		Person bob = ctx.getBean("programmer", Person.class);
		
		int useTime = 0;
		try {
			useTime = alice.usingComputer("1234");
			System.out.println("alice 사용시간 : " + useTime);
		}catch(Throwable e) {
			System.out.println(e.getMessage() + "예외처리 완료!");
		}
		System.out.println("-------------");
		try {
			useTime = bob.usingComputer("5678");
			System.out.println("bob 사용시간 : " + useTime);
		}catch(Throwable e) {
			System.out.println(e.getMessage() + "예외처리 완료!");
		}
	}
}
