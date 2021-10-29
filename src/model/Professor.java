package model;

public class Professor {
	private String pno;
	private String password;
	private String major;
	private String name;
	private String state;
	private String address;
	private String pro_room;
	private String tel;
	private String email;
	private String d_name;
	private int dno;	
	
	

	@Override
	public String toString() {
		return "Professor [pno=" + pno + ", password=" + password + ", major=" + major + ", name=" + name + ", state="
				+ state + ", address=" + address + ", pro_room=" + pro_room + ", tel=" + tel + ", email=" + email
				+ ", d_name=" + d_name + ", dno=" + dno + "]";
	}

	public Professor() {}
	
	public Professor(String pno, String password, String major, String name, String address,
			String pro_room, String tel, String email, String d_name) {
		super();
		this.pno = pno;
		this.password = password;
		this.major = major;
		this.name = name;
		this.address = address;
		this.pro_room = pro_room;
		this.tel = tel;
		this.email = email;
		this.d_name = d_name;
	}



	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}  
	
	
	
	
	
}
