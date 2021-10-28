package dao.subject;

import java.util.List;

import model.Subject;

public interface SubjectDao {
	public List<Subject> selectAll();
	List<Subject> selectByNS(String name,String subject);
	void insert(Subject subject);
	Subject select_by_subno(String subno);
}
