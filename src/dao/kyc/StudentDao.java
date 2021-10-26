package dao.kyc;

import java.util.List;

import model.Student;

public interface StudentDao {

	public List<Student> selectAll();
	public List<Student> selectName(String name);
	public List<Student> selectYear(int year);
	public Student selectByNo(String sno);
	public void updateToScore(int regno, String score);
	public List<Student> selectBySubjectNo(int subno);
	
}
