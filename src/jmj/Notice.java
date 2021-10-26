package jmj;

public class Notice {
	private int Nno;/* 번호 */
	private String time;  /* 작성일자 */
	private String division; /* 공지구분 */
	private String subject; /* 제목 */
	private String contents;  /* 내용 */
	private int views;  /* 조회수 */
	private int id; /* 아이디 */
	public int getNno() {
		return Nno;
	}
	public void setNno(int nno) {
		Nno = nno;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
