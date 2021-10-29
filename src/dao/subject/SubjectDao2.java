package dao.subject;

import java.util.List;

import model.Subject;

public interface SubjectDao2 {
	
	List<Subject> selectByPno(String pno);
	List<Subject> selectByRegisterYearAndSemester(String pno, int year, int semester);

	Subject selectBySubno(String subno);
	List<Subject> selectAll(int dno);
	List<Subject> selectByDivision(String division, int dno);
	List<Subject> selectByDivisionAndGrade(String division, int dno, String grade);


	Subject selectBySubno(int subno);


}
