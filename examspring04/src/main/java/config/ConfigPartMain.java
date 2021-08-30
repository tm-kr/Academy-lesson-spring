package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
@Import(ConfigPartSub.class) //사용할 자바 설정 파일
public class ConfigPartMain {
	
	public ConfigPartMain() {
		System.out.println("ConfigPartMain()");
	}
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	} 
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
}







