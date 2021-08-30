package aop01proxy;

public class Test01 {
	public static void main(String[] args) {
		ProGamer alice = new ProGamer();
		Programmer bob = new Programmer();
		
		Person p1 = new CommonPerson(alice);
		Person p2 = new CommonPerson(bob);

		int useTime = 0;
		useTime = p1.usingComputer("1234");
		System.out.println("-------------");
		useTime = p2.usingComputer("5678");
	}
}
