package model;

public class Register {
	
	private int regno;
	private int year;
	private int semester;
	private String score;
	private int sno;
	private String subno;
	
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSubno() {
		return subno;
	}
	public void setSubno(String subno) {
		this.subno = subno;
	}
	@Override
	public String toString() {
		return "Register [regno=" + regno + ", year=" + year + ", semester=" + semester + ", score=" + score + ", sno="
				+ sno + ", subno=" + subno + "]";
	}
	
	
	
}
