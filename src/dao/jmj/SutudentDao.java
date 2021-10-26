package dao.jmj;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jmj.Notice;
import jmj.SystemMaster;
import model.Student;

public interface SutudentDao {
	
	//�α���
	model.Student login(int sno, String pw);
	Student mylogin(String pw);
	List<SystemMaster> selectDepCode(); 
	
	
	Student selectBysno(int sno);
	//ȸ������ ����
	int  loginProcess(HttpServletRequest request, Student student);

//	//��������
//	List<Notice> selectAll(int reqestPage);
	
	
	Notice selectBymemoid(int Nno);
	
	
	//�Խ���
//	List<Board> selectBoardAll();
//	Board selectBysubject(int nom);
	
}
