package aop10;

import org.aspectj.lang.ProceedingJoinPoint;

public class PlayAspect {
	
	public Object playing(ProceedingJoinPoint pjp) throws Throwable {
		
		String pwd = (String)pjp.getArgs()[0];
		System.out.println("컴퓨터 부팅 및 " + pwd + "를 입력하여 로그인");

		Object result = null;
		try {
			result = pjp.proceed(); //핵심 기능 호출
			String computer = pjp.getTarget().getClass().getSimpleName();
			System.out.println(computer + " 작업 종료");
			
		}catch(Throwable e) {
			System.out.println(e.getMessage() + " 예외 발생! - AS신청!");
		}
		
		String computer = pjp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "시스템 종료!");
		
		return result;
		
	}
}
