package ihk.student.model;

public class Student {
	private int sno;
	private String name;
	private int year;
	private String d_name;
	private String tel;
	private String state;
	
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
