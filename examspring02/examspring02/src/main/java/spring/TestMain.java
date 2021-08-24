package spring;

public class TestMain {
	public static void main(String[] args) {
		Assembler assm = new Assembler();
		
		MemberRegisterService regSvc = assm.getMemberRegisterService();
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("test@test.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");

		if(regReq.isPasswordEqualsToConfirmPassword()) {
			regSvc.regist(regReq);
		}else {
			System.out.println("비밀번호 확인");
		}
		
		MemberDao memberDao = assm.getMemberDao();
		System.out.println(memberDao.selectByEmail(regReq.getEmail()));
		
		ChangePasswordService pwdSvc = assm.getChangePasswordService();
		try {
			pwdSvc.changePassword(regReq.getEmail(), "1234", "4321");
		}catch(MemberNotFoundException e) {
			System.out.println("멤버가 없습니다.");
		}
		System.out.println(memberDao.selectByEmail(regReq.getEmail()));
		
	}
}
