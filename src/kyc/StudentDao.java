package kyc;

import java.util.List;

public interface StudentDao {

	public List<Student> selectAll();
	public List<Student> selectName(String name);
	public List<Student> selectYear(int year);
	public Student selectByNo(String sno);
	
}
