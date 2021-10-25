package mjh;

import java.util.List;

public interface ProfessorDao {
	void insert(Professor professor);
	void update(String pno, String state);
	List<Professor> selectAll();
	List<Professor> selectByND(String name,String department);
}
