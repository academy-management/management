package model;

public class Student {
	private int sno;
	private String name;
	private int year;
	private String d_name;     //��怨�
	private String tel;
	private String state;
	private String password;
	private String address;
	private String email;
	private String dname;
	private String subno;
	private int regno;
	private String score;
	private int dno;
	private int grade;
	
	
	public Student() {
		super();
	}
	public Student(int sno, String name, int year, String d_name, String tel, String state, String password,
			String address, String email, String dname, String subno, int regno, String score, int dno, int grade) {
		super();
		this.sno = sno;
		this.name = name;
		this.year = year;
		this.d_name = d_name;
		this.tel = tel;
		this.state = state;
		this.password = password;
		this.address = address;
		this.email = email;

	}
	public Student(int sno,String name,int year,String d_name, String tel,String password,String address,String email) {
		super();
		this.sno = sno;
		this.name = name;
		this.year = year;
		this.d_name = d_name;
		this.tel = tel;
		this.password = password;
		this.address = address;
		this.email = email;

	}
	
	public Student(String name ,String password,String tel,String email,String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.password = password;
		this.address = address;
		this.email = email;

	}
	
	
	public Student(int sno, String password){
		this.sno = sno;
		this.password = password;
	}
	

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getSubno() {
		return subno;
	}
	public void setSubno(String subno) {
		this.subno = subno;
	}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", year=" + year + ", d_name=" + d_name + ", tel=" + tel
				+ ", state=" + state + ", password=" + password + ", address=" + address + ", email=" + email
				+ ", dname=" + dname + ", subno=" + subno + ", regno=" + regno + ", score=" + score + ", dno=" + dno
				+ ", grade=" + grade + "]";
	}
	
		
}
