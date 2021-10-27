package model;

public class Manager {
	private int id;
	private String name;
	private String password;
	private String tel;
	private String email;
	private String address;
	
	
	
	public Manager() {
		super();
	}
	public Manager(int id, String name, String password, String tel, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", password=" + password + ", tel=" + tel + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
}
