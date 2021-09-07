package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao2 {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao2(DataSource dataSource) {
		System.out.println("MemberDao(DataSource)");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) { //select
		List<Member> result = jdbcTemplate.query(
				"select \"ID\", \"EMAIL\", \"PASSWORD\", \"NAME\", \"REGDATE\" from"
				+ " \"MEMBER\" where \"EMAIL\"=?", 
				new MemberRowMapper(),
				email);
		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<Member> selectAll(){
		List<Member> result = jdbcTemplate.query(
				"select \"ID\", \"EMAIL\", \"PASSWORD\", \"NAME\", \"REGDATE\" from \"MEMBER\"",
				new MemberRowMapper());
		return result;
	}
	
	public int count() {
		String query = "select count(*) from \"MEMBER\"";
		//쿼리 결과가 하나만 있을 경우 활용(쿼리 결과가 하나가 아니면 예외)
		return jdbcTemplate.queryForObject(query, Integer.class);
	}
	
//  insert, update, delete를 구현하는 방법 1
//	public void update(Member member) { //update
//		String query = "update \"MEMBER\" set \"NAME\"= ?, \"PASSWORD\" = ? where \"EMAIL\"= ?";
//		jdbcTemplate.update(query, member.getName(), member.getPassword(), member.getEmail());
//	}

//  insert, update, delete를 구현하는 방법 2
//	class MyPreparedStatementCreator implements PreparedStatementCreator{
//
//		private Member member;
//		
//		public MyPreparedStatementCreator(Member member) {
//			this.member = member;
//		}
//		
//		@Override
//		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//			String query = "update \"MEMBER\" set \"NAME\"= ?, \"PASSWORD\" = ? where \"EMAIL\"= ?";
//			PreparedStatement pstmt = con.prepareStatement(query);
//			pstmt.setString(1, member.getName());
//			pstmt.setString(2, member.getPassword());
//			pstmt.setString(3, member.getEmail());
//			return pstmt;
//		}
//		
//	}
//	
//	public void update(Member member) {
//		jdbcTemplate.update(new MyPreparedStatementCreator(member));
//	}
	
	
//  insert, update, delete를 구현하는 방법 3(익명(무명)중첩클래스 활용)
	public void update(Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "update \"MEMBER\" set \"NAME\"= ?, \"PASSWORD\" = ? where \"EMAIL\"= ?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getEmail());
				return pstmt;
			}
			
		});
	}

	
	
	public void insert(Member member){ //insert
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = "insert into \"MEMBER\" (\"ID\", \"EMAIL\", \"PASSWORD\", \"NAME\", \"REGDATE\")"
				+ " values (\"MEMBER_SEQ\".nextval, ?, ?, ?, sysdate)";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(query, new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());

				return pstmt;
			}
			
		}, keyHolder); //prepareStatement에 전달한 String배열에 해당하는 컬럼에 사용된 값을 키홀더에 저장
		Number key = keyHolder.getKey();
		member.setId(key.longValue());
	}
	
	public List<Member> selectByRegdate(Date from, Date to){ //java.util.Date
		List<Member> results = jdbcTemplate.query(
				"select * from \"MEMBER\" where \"REGDATE\" between ? and ? order by \"REGDATE\" desc",
				new MemberRowMapper(), 
				from,
				to);
		return results;
	}

	public Member selectById(Long id) {
		List<Member> results = 
				jdbcTemplate.query(
						"select * from \"MEMBER\" where \"ID\" = ?", 
						new MemberRowMapper(),
						id);
				
		return results.isEmpty() ? null : results.get(0);
	}
		
}
























