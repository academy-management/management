package dao.Register;

import model.Register;

public class Test {
	
	public static void main(String[] args) {
		
		RegisterDao dao = new RegisterDaoImpl();
		
		Register register = new Register();
		
		register.setScore("A");
		register.setSemester(2);
		register.setSno(20210101);
		register.setSubno("1111");
		register.setYear(2021);

		dao.insert(register);
		
	}

}
