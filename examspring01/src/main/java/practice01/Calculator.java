package practice01;

public class Calculator {
	private char op;
	private int n1;
	private int n2;

	public void setOp(char op) {
		this.op = op;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public Object calcResult() {
		return n1 + " " + op + " " + n2 + " = " + oper();
	}

	private Object oper() {
		switch (op) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '/':
			return (double) (n1 / (double) n2);
		case '*':
			return n1 * n2;
		default:
			return "잘못된 입력입니다. 그걸 어떻게 계산해 바보야";
		}
	}
}
