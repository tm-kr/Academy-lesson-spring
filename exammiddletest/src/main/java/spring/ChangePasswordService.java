package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	
	public ChangePasswordService() {
		System.out.println("ChangePasswordService()");
	}
	
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("setMemberDao(memberDao)");
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
