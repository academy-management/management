package controller.Professor;

import java.util.List;

import dao.Professor.ProfessorDao;
import dao.Professor.ProfessorDao2;
import dao.Professor.ProfessorDaoImpl;
import dao.Professor.ProfessorDaoImpl2;
import model.Professor;

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
		
		for (Professor professor : proList) {
			System.out.println(professor.getPno() +" , " + professor.getPassword());
		}
	}

}
