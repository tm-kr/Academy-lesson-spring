package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	@Autowired
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public MemberInfoPrinter() {
		System.out.println("MemberInfoPrinter()");
	}
	
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("setMemberDao(MemberDao)");
		this.memberDao = memberDao;
	}
	
	@Autowired
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







