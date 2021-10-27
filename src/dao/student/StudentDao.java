package dao.student;

import java.util.List;

import model.Student;
import model.SystemMaster;

public interface StudentDao {
	
	model.Student login(int sno, String pw);
	Student mylogin(String pw);
	List<SystemMaster> selectDepCode();	
	void insert(Student student);
	void update(int sno, String state);	
	List<Student> selectByNYN(String name,String year,String department);
	public List<Student> selectAll();
	public List<Student> selectName(String name);
	public List<Student> selectYear(String year);
	public Student selectByNo(String sno);
	public void updateToScore(int regno, String score);
<<<<<<< HEAD
	public List<Student> selectBySubjectNo(String subno);
	
=======
	public List<Student> selectBySubjectNo(int subno);
	Student selectByuser(int sno);
	void studentUpdate(Student student);
>>>>>>> branch 'main' of https://github.com/academy-management/management.git
}
