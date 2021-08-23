package practice01;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		Calculator calc = ctx.getBean("calc", Calculator.class);
		System.out.print("연산자 입력: ");
		calc.setOp(in.nextLine().charAt(0));
		System.out.print("첫번째 수 입력: ");
		calc.setN1(in.nextInt());
		System.out.print("두번째 수 입력: ");
		calc.setN2(in.nextInt());
		System.out.println(calc.calcResult());
		
	}
}
