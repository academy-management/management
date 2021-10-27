package controller.Student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import model.Student;

@WebServlet(urlPatterns = {"/student_mylogin","/student_myloginpage","/student_user_detail"})
public class StudentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		//로직
		if(action.equals("student_mylogin")) {

		}
		else if(action.equals("student_myloginpage")) {  //비번 치는 화면
			
			
			String password = req.getParameter("password");
			
			
			HttpSession session= req.getSession();
			
			Student Student = (Student)session.getAttribute("member");
			
			if(password.equals(Student.getPassword())) {
				//추가 한 부분
				int sno = Integer.parseInt(req.getParameter("sno"));
				StudentDao dao = new StudentDaoImpl();
				Student student = dao.selectByuser(sno);
				req.setAttribute("student", student);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/Student/st_mypage.jsp"); //회원정보 화면
				
				rd.forward(req, resp);
			}else {
				req.setAttribute("message", "비밀번호가 일치 하지않습니다.");
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/Student/st_mylogin.jsp");
				rd.forward(req, resp);
			}
		}else if(action.equals("student_user_update")) {
			int sno = Integer.parseInt(req.getParameter("sno"));
			
			StudentDao dao = new StudentDaoImpl();
			Student student = dao.selectByuser(sno);
			
			req.setAttribute("student", student);
		}
//		else if(action.equals("student_user_update")) {
//			int sno = Integer.parseInt(req.getParameter("sno"));
//			int dno = Integer.parseInt(req.getParameter("dno"));
//			String name = req.getParameter("name");
//			String password = req.getParameter("password");
//			String tel = req.getParameter("tel");
//			String email = req.getParameter("email");
//			String address = req.getParameter("address");
//
//			Student student = new Student(sno, dno, name, password, tel, email, address);
//			
//			
//			StudentDao dao = new StudentDaoImpl();
//			dao.studentUpdate(student);
//			
//			
//		}
		
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("student_mylogin")) {
			dispatcherUrl = "/jsp/Student/st_mylogin.jsp"; 
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}	
}
//			int sno = Integer.parseInt(req.getParameter("sno"));
//
//StudentDao dao = new StudentDaoImpl();
//Student student = dao.selectByuser(sno);
//
//req.setAttribute("student", student);
