package ihk.professor.model;

import java.sql.Blob;

public class Professor {
	
	private int pno;
	private String password;
	private String major;
	private String name;
	private Blob professorImg;
	private String address;
	private String pro_room;
	private String tel;
	private String email;
	private int dno;
	private String dname;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getProfessorImg() {
		return professorImg;
	}
	public void setProfessorImg(Blob professorImg) {
		this.professorImg = professorImg;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPro_room() {
		return pro_room;
	}
	public void setPro_room(String pro_room) {
		this.pro_room = pro_room;
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
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Professor [pno=" + pno + ", password=" + password + ", major=" + major + ", name=" + name
				+ ", professorImg=" + professorImg + ", address=" + address + ", pro_room=" + pro_room + ", tel=" + tel
				+ ", email=" + email + ", dno=" + dno + ", dname=" + dname + "]";
	}

}