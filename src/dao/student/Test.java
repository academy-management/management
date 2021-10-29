package dao.student;

import java.util.List;

import dao.subject.SubjectDao;
import dao.subject.SubjectDaoImpl;
import model.Student;
import model.Subject;

public class Test {
	public static void main(String[] args) {
		
		StudentDao stdDao = new StudentDaoImpl();
		for (Student student: stdDao.selectByPno(1)) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		for (Student student: stdDao.selectName(1, "김학생")) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		for (Student student : stdDao.selectYear(1, "21")) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		System.out.println(stdDao.selectByNo("20210101").toString());
		
		System.out.println("--------------------------------");
		for (Student student  : stdDao.selectBySubjectNo("c0001")) {
			System.out.println(student.toString());
		}
		
	}
}
