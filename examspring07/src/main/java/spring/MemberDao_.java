package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao_ {
	
	private static long nextId = 0; //primary key 역할
	private Map<String, Member> db = new HashMap<>(); //DB역할
	
	public MemberDao_() {
		System.out.println("MemberDao()");
	}
	
	public Member selectByEmail(String email) { //select
		return db.get(email);
	}
	
	public void insert(Member member){ //insert
		member.setId(++nextId);
		db.put(member.getEmail(), member);
	}
	
	public void update(Member member) { //update
		db.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll(){
		return db.values();
	}
	
}







