package ihk.professor.dao;

import ihk.professor.model.Professor;

public interface ProfessorDao {
	
	Professor selectByPno(int pno);
	void update(int pno);

}