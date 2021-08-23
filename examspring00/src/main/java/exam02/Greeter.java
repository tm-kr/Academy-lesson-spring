package exam02;

public class Greeter {
	private String name;
	
	public Greeter() {}
	
	public Greeter(String name) {
		this.setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name + "님 안녕하세요~";
	}
	
}
