package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Test03 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		int n = memberDao.count();
		
		System.out.println("멤버 수:" + n);
		
	}
}
