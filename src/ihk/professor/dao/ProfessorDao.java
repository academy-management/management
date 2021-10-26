package ihk.professor.dao;

import model.Professor;

public interface ProfessorDao {
	
	Professor selectByPno(int pno);
	void update(int pno);

}