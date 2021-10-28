package dao.student;

import java.util.List;

import model.Student;
import model.Subject;
import model.SystemMaster;

public interface StudentDao {
	
	Student login(int sno, String pw);
	Student mylogin(String pw);
	List<SystemMaster> selectDepCode();	
	void insert(Student student);
	void update(int sno, String state);	
	List<Student> selectByNYN(String name,String year,String department);
	public List<Student> selectAll();
	public List<Student> selectName(String name);
	public List<Student> selectYear(String year);
	public Student selectByNo(String sno);
	public void updateToScore(String regno, String score);

	public List<Student> selectBySubjectNo(String subno);
	

	Student selectByuser(int sno); 
	
	void studentUpdate(Student student);
	
	public List<Subject> subjectAll();
	public List<Subject> subjectYear(int year, int semester);
}
