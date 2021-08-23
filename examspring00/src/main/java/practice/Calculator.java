package practice;

public class Calculator {
	private String operator = "";
	private int n1;
	private int n2;
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setNum1(int n1) {
		this.n1 = n1;
	}
	public void setNum2(int n2) {
		this.n2 = n2;
	}
	
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
