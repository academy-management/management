package mjh;

import java.util.List;

import model.Professor;

public interface ProfessorDao {
	void insert(model.Professor professor);
	void update(String pno, String state);
	List<Professor> selectAll();
	List<Professor> selectByND(String name,String department);
}
