package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	@Autowired
	public void setMemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		System.out.println("MemberListPrinter(memberDao, memberPrinter)");
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for(Member member : members) {
			memberPrinter.print(member);
		}
	}
}
