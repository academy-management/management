package model;

public class Subject {
	private String subno;
	private String name;
	private int grade;
	private String score;
	private int people;
	private String room;
	private String date;
	private String state;
	private String start;
	private String end;
	private String division;
	private int dno;
	private String pno;	
	private String p_name;  //교수이름
	private String r_score;  //성적
	private String semester;  
	
	
	public Subject() {
		super();
	}
	
	public Subject(String subno, String name, int grade, String score, int people, String room, String date,
			String state, String start, String end) {
		super();
		this.subno = subno;
		this.name = name;
		this.grade = grade;
		this.score = score;
		this.people = people;
		this.room = room;
		this.date = date;
		this.state = state;
		this.start = start;
		this.end = end;
	}

	public Subject(String subno, String name, int grade, String score, int people, String room, String date, String state,
			String start, String end, String division, int dno, String pno) {
		super();
		this.subno = subno;
		this.name = name;
		this.grade = grade;
		this.score = score;
		this.people = people;
		this.room = room;
		this.date = date;
		this.state = state;
		this.start = start;
		this.end = end;
		this.division = division;
		this.dno = dno;
		this.pno = pno;
	}
	
	
	public Subject(String subno, String name, int grade, String score, int people, String room, String date,
			String start, String end, String division, int dno, String pno) {
		super();
		this.subno = subno;
		this.name = name;
		this.grade = grade;
		this.score = score;
		this.people = people;
		this.room = room;
		this.date = date;
		this.start = start;
		this.end = end;
		this.division = division;
		this.dno = dno;
		this.pno = pno;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getSubno() {
		return subno;
	}
	public void setSubno(String subno) {
		this.subno = subno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	
	
	
	public String getR_score() {
		return r_score;
	}

	public void setR_score(String r_score) {
		this.r_score = r_score;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Subject [subno=" + subno + ", name=" + name + ", grade=" + grade + ", score=" + score + ", people="
				+ people + ", room=" + room + ", date=" + date + ", state=" + state + ", start=" + start + ", end="
				+ end + ", division=" + division + ", dno=" + dno + ", pno=" + pno + "]";
	}	
}
