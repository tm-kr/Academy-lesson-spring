package aop09;

import java.util.Scanner;

public class Programmer implements Person{
	
	@Override
	public int usingComputer(String pwd) {
		
		System.out.println("[코딩을 한다.]");
		
		Scanner in = new Scanner(System.in);
		System.out.print("상태 입력(0이면 정상. 1이면 예외):");
		int state = in.nextInt();
		
		if(state == 1) {
			throw new RuntimeException("오류!");
		}
		
		
		return 200; //사용시간 반환
	}
}
