package jmj;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface SutudentDao {
	
	//�α���
	model.Student login(int sno, String pw);
	Studentx mylogin(String pw);
	List<SystemMaster> selectDepCode(); 
	
	
	Studentx selectBysno(int sno);
	//ȸ������ ����
	int  loginProcess(HttpServletRequest request, Studentx student);

//	//��������
//	List<Notice> selectAll(int reqestPage);
	
	
	Notice selectBymemoid(int Nno);
	
	
	//�Խ���
//	List<Board> selectBoardAll();
//	Board selectBysubject(int nom);
	
}
