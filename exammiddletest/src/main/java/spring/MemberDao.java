package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDao(DataSource dataSource) {
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
		return jdbcTemplate.queryForObject(query, Integer.class);
	}
	
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
			
		}, keyHolder);
		Number key = keyHolder.getKey();
		member.setId(key.longValue());
	}
		
}
























