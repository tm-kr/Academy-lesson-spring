package spring;

import java.util.Date;
import java.util.List;

public interface MemberDao {

	public Member selectByEmail(String email);
	
	public List<Member> selectAll();
	
	public int count() ;
	
	public void update(Member member);
	
	public void insert(Member member);
	
	public List<Member> selectByRegdate(Date from, Date to);

	public Member selectById(Long id);
		
}
























