package aop01proxy;

public class ProGamer implements Person{
	
	@Override
	public int usingComputer(String pwd) {
		//System.out.println("컴퓨터 부팅 후 " + pwd + "를 입력하여 로그인");
		
		try {
			System.out.println("게임을 한다.");
			System.out.println("게임 종료");
		}catch(Exception e) {
			if(e.getMessage().equals("부팅오류")) {
				System.out.println("AS를 신청");
			}
		}
		
		//System.out.println("컴퓨터 종료");
		return 100; //사용시간 반환
	}
}
