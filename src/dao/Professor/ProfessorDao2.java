package dao.Professor;

import java.util.List;

import model.Professor;
import model.Subject;

public interface ProfessorDao2 {
	
	void update(Professor professor);
	
	public List<Professor> Professordep(int professor_ch);
	public List<Professor> ProfessorAllInformation();
}
