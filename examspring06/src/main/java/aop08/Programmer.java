package aop08;

public class Programmer implements Person{
	
	@Override
	public int usingComputer(String pwd) {
		
		try {
			System.out.println("코딩을 한다.");
		}catch(Exception e) {
			if(e.getMessage().equals("부팅오류")) {
				System.out.println("AS를 신청");
			}
		}
		
		return 200; //사용시간 반환
	}
}
