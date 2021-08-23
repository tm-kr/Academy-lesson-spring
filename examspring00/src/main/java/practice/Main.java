package practice;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import exam02.Greeter;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연산자 입력: ");
		String operator = sc.nextLine();
		System.out.print("첫 번째 수 입력 : ");
		int n1 = sc.nextInt();
		sc.nextLine();
		System.out.print("두 번째 수 입력: ");
		int n2 = sc.nextInt();
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		Calculator op = ctx.getBean("operator", Calculator.class);
		op.setOperator(operator);
		op.setNum1(n1);
		op.setNum2(n2);
		
		System.out.println(n1 + " " + operator + " " + n2 + " = " + op.calc(operator, n1, n2));
	}
}
