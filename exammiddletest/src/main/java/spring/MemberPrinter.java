package spring;

import org.springframework.stereotype.Component;

@Component
public class MemberPrinter {
	public MemberPrinter() {
		System.out.println("MemberPrinter()");
	}
	
	public void print(Member member) {
		System.out.println(member);
	}
}
