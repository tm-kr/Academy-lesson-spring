package spring;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Test04 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");

		Random ran = new Random();
		String name = "LKC" + ran.nextInt();
		String pw = String.valueOf(ran.nextInt());

		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		Member member = memberDao.selectByEmail("garnet2929@naver.com");
		System.out.println("member:" + member);
		
		member.setName(name);
		member.setPassword(pw);
		memberDao.update(member);
		
		List<Member> ls = memberDao.selectAll();
		
		for(Member m : ls) {
			System.out.println(m);
		}
		
	}
}
