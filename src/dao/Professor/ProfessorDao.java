package dao.Professor;

import java.util.List;

import model.Professor;

public interface ProfessorDao {
	
	Professor selectByPno(int pno);
	void update(int pno);
	
	void insert(model.Professor professor);
	void update(String pno, String state);
	List<Professor> selectAll();
	List<Professor> selectByND(String name,String department);
	

}