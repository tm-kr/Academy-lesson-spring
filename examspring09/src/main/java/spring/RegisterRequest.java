package spring;

public class RegisterRequest {
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public RegisterRequest() {
		System.out.println("RegisterRequest()");
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		System.out.println("setEmail");
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("setPassword");
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		System.out.println("setConfirmPassword");
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}
	@Override
	public String toString() {
		return "RegisterRequest [email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", name=" + name + "]";
	}
	
	public boolean isPasswordEqualsToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	
}
