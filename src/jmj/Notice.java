package jmj;

public class Notice {
	private int Nno;/* ��ȣ */
	private String time;  /* �ۼ����� */
	private String division; /* �������� */
	private String subject; /* ���� */
	private String contents;  /* ���� */
	private int views;  /* ��ȸ�� */
	private int id; /* ���̵� */
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
