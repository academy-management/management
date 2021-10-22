package mjh;

import java.util.List;

public interface StudentDao {
	void insert(Student student);
	//int selectCntById(String id);
	
	//Student login(String id, String pwd);
	//void update(Product product);
	//void delete(int productid);
	
	List<Student> selectAll();
	
	//Student selectByCustomerseq(int customerseq);
}
