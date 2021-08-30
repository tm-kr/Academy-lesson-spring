package spring;

import java.util.Date;

import javax.annotation.Resource;

public class MemberRegisterService {
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
		System.out.println("MemberRegisterService(MemberDao)");
	}
	
	public void regist(RegisterRequest regReq) {
		Member member = memberDao.selectByEmail(regReq.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException(member.getEmail() + "는 이미 등록된 이메일입니다.");
		}
		Member newMember = new Member(
				regReq.getEmail(),
				regReq.getPassword(),
				regReq.getName(),
				new Date() //java.util.Date
				);
		memberDao.insert(newMember);
	}
}
