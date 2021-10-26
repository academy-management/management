package mjh;

import model.Student;

public class test {
	public static void main(String[] args) {
		StudentDao dao = new StudentDaoImpl();
		
		Student student = new Student();
		
		System.out.println(dao.selectAll().toString());
	
	
	}

	
	
}
