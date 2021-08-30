package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		Member member = null;
		member = memberDao.selectByEmail("garnet2929@naver.com");
		System.out.println("member:" + member);
		member = memberDao.selectByEmail("tester@test.com");
		System.out.println("member:" + member);
	}
}
