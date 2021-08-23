package exam02;


import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		System.out.println("스프링 컨테이너 준비완료");
		Greeter g = ctx.getBean("greeter", Greeter.class);
		g.setName("홍길동");
		System.out.println(g.getName());
		
		Greeter g2 = ctx.getBean("greeter2", Greeter.class);
		Greeter g3 = ctx.getBean("greeter3", Greeter.class);
		System.out.println(g2.getName());
		System.out.println(g3.getName());
		System.out.println("스프링 컨테이너 제거");
		ctx.close();
	}
}
