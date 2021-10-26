package jmj;

public class Student {
	
	private long customerseq;
	private int sno; 
	private String password;
	private String name;
	private int grade;
	private int year;
	private String address;
	private String tel;
	private String email;
	private String state;
	private int dno;
	
	public Student(){}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public long getCustomerseq() {
		return customerseq;
	}
	public void setCustomerseq(long customerseq) {
		this.customerseq = customerseq;
	}
	
	
	
}
