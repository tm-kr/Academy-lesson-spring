package spring;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Test05 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");

		Random ran = new Random();
		String email = "garnet2929"+ran.nextInt() + "@naver.com";
		String name = "LKC" + ran.nextInt();
		String pw = String.valueOf(ran.nextInt());

		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		Member member = new Member(email, pw, name, null);
		System.out.println("member:" + member);
		memberDao.insert(member);
		System.out.println("member:" + member); //ID값이 확인됨
		
		List<Member> ls = memberDao.selectAll();
		
		for(Member m : ls) {
			System.out.println(m);
		}
		
	}
}
