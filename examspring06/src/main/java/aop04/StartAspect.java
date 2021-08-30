package aop04;

import org.aspectj.lang.JoinPoint;
//POJO(Plain Old Java Object)
public class StartAspect {
	
	public void bootingAndLogin(JoinPoint jp) {
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 및 " + pwd + "를 입력하여 로그인");
	}
	
}
