package kyc;

import java.util.List;

import model.Student;
import model.Subject;

public class Test {
	public static void main(String[] args) {
//		new Test().stdTest();
		new Test().subjectTest();
	}
	public void subjectTest() {
		SubjectDao subDao = new SubjectDaoImpl();
		for (Subject subject : subDao.selectAll()) {
			System.out.println(subject.toString());
		}
	}
	
	public void stdTest() {
		StudentDao stdDao = new StudentDaoImpl();
		for (Student student: stdDao.selectAll()) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		for (Student student: stdDao.selectName("김학생")) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		for (Student student : stdDao.selectYear(21)) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		System.out.println(stdDao.selectByNo("20210101").toString());
	}
}
