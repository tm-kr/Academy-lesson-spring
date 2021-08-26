package exam;

public class CalcMain {
	public static void main(String[] args) {
		AddCalculator addCalc = new AddCalculator();
		MinCalculator minCalc = new MinCalculator();
		
		System.out.println(addCalc.calculate(10, 5));
		System.out.println(minCalc.calculate(10, 5));
		
		//덧셈, 뺄샘 동작 시 공통적으로 계산할 값을 콘솔에 로그로 남겨야 한다면?
	}
}
