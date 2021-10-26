package dao.notice;

import java.util.List;

import model.Notice;

public interface NoticeDao {
	
	List<Notice> selectAll(int requestPage);
	List<Notice> selectByDivision(int requestPage, String division);
	List<Notice> selectBySubject(int requestPage, String subject);
	List<Notice> selectByDivisionAndSubject(int requestPage, String division, String subject);
	
	Notice selectByNno(int nno);
	void updateToViews(int views, int nno);
	
}
