package aop01;

public class Test01 {
	public static void main(String[] args) {
		ProGamer alice = new ProGamer();
		Programmer bob = new Programmer();

		int useTime = 0;
		useTime = alice.usingComputer("1234");
		System.out.println("-------------");
		useTime = bob.usingComputer("5678");
	}
}
