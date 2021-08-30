package spring;

public class Client2{
	private String host;
	
	public Client2() {
		System.out.println("Client2()");
	}
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client2.setHost() 실행");
	}
	
	public void send() {
		System.out.println("Client2.send() to " + host);
	}
	
	public void ini() {
		System.out.println("Client2.ini() 초기화에 사용");
	}
	
	public void fin() {
		System.out.println("Client2.fin() 소멸에 사용");
	}
}
