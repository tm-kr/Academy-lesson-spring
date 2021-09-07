package spring;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDaoImpl implements MemberDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	private String namespace = "memberDao";

	@Override
	public Member selectByEmail(String email) {
		return sqlSessionTemplate.selectOne(namespace + ".selectByEmail", email);
	}

	@Override
	public List<Member> selectAll() {
		return sqlSessionTemplate.selectList(namespace + ".list");
	}

	@Override
	public int count() {
		return sqlSessionTemplate.selectOne(namespace + ".count");
	}

	@Override
	public void update(Member member) {
		int ret = sqlSessionTemplate.update(namespace + ".update", member);
		System.out.println("update 결과: " + ret);
	}

	@Override
	public void insert(Member member) {
		int ret = sqlSessionTemplate.insert(namespace + ".insert", member);
		System.out.println("insert 결과: " + ret);
	}

	@Override
	public List<Member> selectByRegdate(Date from, Date to) {
		HashMap<String, Date> map = new HashMap<>();
		map.put("from", from);
		map.put("to", to);
		return sqlSessionTemplate.selectList(namespace + ".selectByRegdate", map);
	}

	@Override
	public Member selectById(Long id) {
		return sqlSessionTemplate.selectOne(namespace + ".selectById", id);
	}

}
