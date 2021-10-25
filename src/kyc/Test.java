package kyc;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		StudentDao dao = new StudentImpl();
		for (Student student: dao.selectAll()) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		for (Student student: dao.selectName("�迵â")) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		for (Student student : dao.selectYear(21)) {
			System.out.println(student.toString());
		}
		
		System.out.println("--------------------------------");
		System.out.println(dao.selectByNo("20210101").toString());
	}
}
