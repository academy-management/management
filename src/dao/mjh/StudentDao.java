package dao.mjh;

import java.util.List;

import model.Student;

public interface StudentDao {
	void insert(Student student);
	void update(int sno, String state);
	List<Student> selectAll();
	List<Student> selectByNYN(String name,String year,String department);
}
