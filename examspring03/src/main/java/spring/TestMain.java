package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("test@test.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");

		if(regReq.isPasswordEqualsToConfirmPassword()) {
			regSvc.regist(regReq);
		}else {
			System.out.println("비밀번호 확인");
		}
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		System.out.println(memberDao.selectByEmail(regReq.getEmail()));
		
		MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(regReq.getEmail());
		
	}
}
