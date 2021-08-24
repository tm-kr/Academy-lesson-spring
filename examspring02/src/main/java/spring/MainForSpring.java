package spring;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어 입력>");
			String cmd = in.nextLine();
			//cmdPrint(cmd.split(" "));
			if(cmd.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				break;
			}
			if(cmd.startsWith("new")) { //new a@a.com lkc 1234 1234
				processNewCommand(cmd.split(" "));
				continue;
			}else if(cmd.startsWith("change")) {
				processChangeCommand(cmd.split(" "));
				continue;
			}
			printHelp();
		}
	}
	
	//private static Assembler assembler = new Assembler();
	private static GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext("classpath:appctx.xml");
	
	private static void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);//assembler.getMemberRegisterService();
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail(args[1]);
		regReq.setName(args[2]);
		regReq.setPassword(args[3]);
		regReq.setConfirmPassword(args[4]);
		
		if(!regReq.isPasswordEqualsToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않음");
			return;
		}
		
		try {
			regSvc.regist(regReq);
			System.out.println("등록완료");
		}catch(AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일");
		}
	}
	
	private static void processChangeCommand(String[] args) {
		if(args.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService pwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);//assembler.getChangePasswordService();
		
		try {
			pwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호 변경 성공");
		}catch(MemberNotFoundException e) {
			System.out.println("이메일이 존재하지 않음");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않음");
		}
	}
	
	private static void printHelp() {
		System.out.println("사용법:");
		System.out.println(" new <이메일> <이름> <비밀번호> <비밀번호확인>");
		System.out.println(" change <이메일> <현재비밀번호> <새로운비밀번호>");
	}
	
	
	
	private static void cmdPrint(String[] args) {
		if(args.length == 1) {
			return;
		}
		for(int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]:" + args[i]);
		}
	}
}
