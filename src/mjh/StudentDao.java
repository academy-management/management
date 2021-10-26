package mjh;

import java.util.List;

public interface StudentDao {
	void insert(model.Student student);
	void update(int sno, String state);
	List<Student> selectAll();
	List<Student> selectByNYN(String name,String year,String department);
}
