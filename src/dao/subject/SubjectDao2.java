package dao.subject;

import java.util.List;

import model.Subject;

public interface SubjectDao2 {
	
	List<Subject> selectByPno(String pno);
	List<Subject> selectByRegisterYearAndSemester(String pno, int year, int semester);
	Subject selectBySubno(int subno);

}
