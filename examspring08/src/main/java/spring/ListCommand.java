package spring;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ListCommand {
	@DateTimeFormat(pattern = "yyyyMMddHH") //형식이 맞지 않으면 typeMismatch 에러
					//입력값: 2020122510 //2020년 12월 25일 10시 값을 가지는 Date객체 생성
	private Date from;
	
	@DateTimeFormat(pattern = "yyyyMMddHH")
	private Date to;
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
}
