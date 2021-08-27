package aop08;

public class ProGamer implements Person{
	
	@Override
	public int usingComputer(String pwd) {
		
		try {
			System.out.println("게임을 한다.");
		}catch(Exception e) {
			if(e.getMessage().equals("부팅오류")) {
				System.out.println("AS를 신청");
			}
		}
		
		return 100; //사용시간 반환
	}
}
