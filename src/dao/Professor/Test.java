package dao.Professor;

import model.Professor;

public class Test {
	
	
	public static void main(String[] args) {
		
		ProfessorDao dao = new ProfessorDaoImpl();
		
		System.out.println(dao.selectByPno("p001").toString());

	}
	
}
