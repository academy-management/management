package jmj;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface SutudentDao {
	
	//로그인
	Student login(int sno, String pw);
	Student mylogin(String pw);
	List<SystemMaster> selectDepCode(); 
	
	
	Student selectBysno(int sno);
	//회원정보 수정
	int  loginProcess(HttpServletRequest request, Student student);

//	//공지사항
//	List<Notice> selectAll(int reqestPage);
	
	
	Notice selectBymemoid(int Nno);
	
	
	//게시판
//	List<Board> selectBoardAll();
//	Board selectBysubject(int nom);
	
}
