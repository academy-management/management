package mjh;

public class Student {
	private int sno;
	private String name;
	private int year;
	private String d_name;     //학과
	private String tel;
	private String state;
	private String password;
	private String address;
	private String email;
	
	public Student() {}
	public Student(int sno, String name, int year, String d_name, String tel, String password, String address,
			String email) {
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

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", year=" + year + ", d_name=" + d_name + ", tel=" + tel
				+ ", state=" + state + "]";
	}
	
	
}
