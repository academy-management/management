package dao.Professor;

import java.util.List;

import model.Professor;

public interface ProfessorDao2 {
	
	void update(Professor professor);
	
	public List<Professor> ProfessorAllInformation();
}
