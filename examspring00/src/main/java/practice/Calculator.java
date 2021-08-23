package practice;

public class Calculator {
	
	public int calc(String operator, int n1, int n2) {
		if(operator.equals("+")) {
			return n1+n2;
		}else if(operator.equals("-")) {
			return n1-n2;
		}else if(operator.equals("*")) {
			return n1*n2;
		}else if(operator.equals("/")) {
			return n1 / n2;
		}else {
			return -99999999;
		}
	}
}
