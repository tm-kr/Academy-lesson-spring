package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client;
import spring.Client2;

@Configuration
public class JavaConfig {

	@Bean
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
