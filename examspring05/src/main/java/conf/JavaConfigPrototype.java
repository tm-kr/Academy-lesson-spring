package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client;
import spring.Client2;

@Configuration
public class JavaConfigPrototype {

	@Bean
	@Scope("prototype") //getBean()이 호출 될 때마다 객체를 생성(컨테이너에서 관리하지 않음)
	public Client client() {
		Client client = new Client();
		client.setHost("어떤 서버");
		return client;
	}
	
	@Bean(initMethod = "ini", destroyMethod = "fin")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("어떤 서버2");
		return client2;
	}
}
