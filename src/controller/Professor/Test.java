package controller.Professor;

import java.util.List;

import dao.Professor.ProfessorDao;
import dao.Professor.ProfessorDao2;
import dao.Professor.ProfessorDaoImpl;
import dao.Professor.ProfessorDaoImpl2;
import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import model.Professor;
import model.Student;
import model.Subject;

public class Test {
	
	public static void main(String[] args) {
		
		Professor p = new Professor();
		
		p.setName("조교수");
		p.setPassword("1111");
		p.setAddress("서울시금천구,길거리");
		p.setTel("11111111111");
		p.setEmail("aaaa@aaaaaaa");
		p.setPno("p001");
		
		ProfessorDao2 dao = new ProfessorDaoImpl2();
		dao.update(p);	
		
		ProfessorDao dao2 = new ProfessorDaoImpl();
		List<Professor> proList = dao2.selectAll();
		
//		for (Professor professor : proList) {
//			System.out.println(professor.getPno() +" , " + professor.getPassword());
//		}
		
		Student st = new Student();
		st.setName("홍길동");
		st.setPassword("0000");
		st.setTel("01012341234");
		st.setEmail("asd@naver.com");	
		st.setAddress("서울시");
		st.setSno(20210101);
		
		StudentDao stdao = new StudentDaoImpl();
		stdao.studentUpdate(st);
		//System.out.println(st.getSno());
		
//		List<Subject> Subject = stdao.subjectAll();
//		for (Subject subject2 : Subject) {
//			System.out.println(Subject.toString());
//		}
		
		
		
		List<Subject> Subject2 = stdao.subjectYear(2021, 1);
		
		for (Subject subject3 : Subject2) {
			System.out.println(Subject2.toString());
		}
		}
	
		

}
