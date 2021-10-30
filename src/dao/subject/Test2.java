package dao.subject;

import java.util.List;

import model.Subject;

public class Test2 {
	
	public static void main(String[] args) {
		
		
		SubjectDao2 dao2 = new SubjectDaoImpl2();
		List<Subject> subjectList = dao2.selectByPno("p001");
		
		for (Subject subject : subjectList) {
			System.out.println(subject.getName());
			System.out.println(subject.getSubno());
		}
		
		
		List<Subject> subjectList2 = dao2.selectByRegisterYearAndSemester("p001", 2021, 2);
		
		for (Subject subject : subjectList2) {
			System.out.println(subject.getName());
		}
		

		System.out.println(dao2.selectBySubno("1234"));
		

	}
	
	
	
	

}
