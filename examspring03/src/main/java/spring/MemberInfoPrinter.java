package spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public MemberInfoPrinter() {
		System.out.println("MemberInfoPrinter()");
	}
	
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("setMemberDao(MemberDao)");
		this.memberDao = memberDao;
	}
	
	@Resource(name="printer2")
	@Qualifier("sysout")
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		System.out.println("setMemberPrinter(MemberPrinter)");
		this.memberPrinter = memberPrinter;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println(email+"회원이 존재하지 않음");
			return;
		}
		memberPrinter.print(member);
	}
}







