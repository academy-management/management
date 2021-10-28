package model;

public class Notice {
	
	private int nno;
	private String time;
	private String division_d;
	private String subject;
	private String contents;
	private int views;
	private int id;
	
	public Notice() {}
	
	
	public Notice(String division_d, String subject, String contents) {
		super();
		this.division_d = division_d;
		this.subject = subject;
		this.contents = contents;
	}
	
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDivision_d() {
		return division_d;
	}
	public void setDivision_d(String division_d) {
		this.division_d = division_d;
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
	@Override
	public String toString() {
		return "Notice [nno=" + nno + ", time=" + time + ", division_d=" + division_d + ", subject=" + subject
				+ ", contents=" + contents + ", views=" + views + ", id=" + id + "]";
	}
	
	
}