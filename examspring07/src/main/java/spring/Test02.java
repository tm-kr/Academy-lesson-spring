package spring;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Test02 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		List<Member> ls = memberDao.selectAll();
		
		for(Member member : ls) {
			System.out.println(member);
		}
	}
}
