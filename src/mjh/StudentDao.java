package mjh;

import java.util.List;

public interface StudentDao {
	void insert(Student student);
	//int selectCntById(String id);
	
	//Student login(String id, String pwd);
	void update(int sno, String state);
	//void delete(int productid);
	
	List<Student> selectAll();
	
	//Student selectByCustomerseq(int customerseq);
}
