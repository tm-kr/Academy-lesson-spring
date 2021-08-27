package aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class StartAspect {
	
	@Before("CommonPointcut.myPointcut()")
	public void bootingAndLogin(JoinPoint jp) {
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 및 " + pwd + "를 입력하여 로그인");
	}
	
}
