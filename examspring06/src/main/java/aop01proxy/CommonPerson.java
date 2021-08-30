package aop01proxy;

//공통 기능 적용을 위한 프록시 객체 정의
public class CommonPerson implements Person{

	private Person person;
	
	public CommonPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public int usingComputer(String pwd) {
		System.out.println("컴퓨터 부팅 후 " + pwd + "를 입력하여 로그인");
		int result = person.usingComputer(pwd); //핵심 기능 호출!
		System.out.println("컴퓨터 종료");
		return result;
	}

}
