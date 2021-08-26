package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean{
	private String host;
	
	public Client() {
		System.out.println("Client()");
	}
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client.setHost() 실행");
	}
	
	public void send() {
		System.out.println("Client.send() to " + host);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//스프링 컨테이너가 빈 생성 후 호출
		System.out.println("Client.afterPropertiesSet()");
	}
	
	@Override
	public void destroy() throws Exception {
		//스프링 컨테이너가 빈 소멸 전에 호출
		System.out.println("Client.destroy()");
	}
}
