package board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("BoardVO")
public class BoardVO {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private int password;
	private Timestamp regDtae;
	private int cnt;
	
	public BoardVO() {
		
	}

	public BoardVO(int seq, String title, String content, String writer, int password, Timestamp regDtae, int cnt) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.regDtae = regDtae;
		this.cnt = cnt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Timestamp getRegDtae() {
		return regDtae;
	}

	public void setRegDtae(Timestamp regDtae) {
		this.regDtae = regDtae;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
