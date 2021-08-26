package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
public class JavaConfig {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	} // <bean id="memberDao" class="spring.MemberDao">와 같은 설정
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	/*
	 <bean id="memberRegSvc" class="spring.MemberRegisterService">
	 	<constructor-arg ref="memberDao"/>
	 </bean>
	 */
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
	}
	/*
	 <bean id="infoPrinter" class="spring.MemberInfoPrinter">
	 	<property name="memberDao" ref="memberDao"/>
		<property name="memberPrinter" ref="printer"/>
	 </bean>
	 */
}







