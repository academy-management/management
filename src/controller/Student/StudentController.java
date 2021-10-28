package controller.Student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import memo.model.Memo;
import model.Student;
import model.Subject;

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
		else if(action.equals("student_myloginpage")) {  
			
			String password = req.getParameter("password"); //비번을 친다
			HttpSession session= req.getSession();
			Student Student = (Student)session.getAttribute("member");
	
			if(password.equals(Student.getPassword())) {
				StudentDao dao = new StudentDaoImpl();
				Student student = dao.selectByuser(Student.getSno());
				req.setAttribute("student", student);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/Student/st_mypage.jsp"); //학생이 비번을 쳐서 들어가는 회원변경 화면
				
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
		else if(action.equals("student_user_update")) {
			
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			String address = req.getParameter("address");

			Student student = new Student(name, password, tel, email, address);
			
			
			StudentDao dao = new StudentDaoImpl();
			dao.studentUpdate(student);
			
		}else if(action.equals("student_score")) {
			String year_ = req.getParameter("year");
			String grade_ = req.getParameter("grade");
			
			String year = "2021";
			if(year_ != null && !year_.equals(""))
				year = year_;
			
			String grade = "";
			if(grade_ != null && !grade_.equals(""))
				grade = grade_;
			
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectAll(year,grade,1);
			
			req.setAttribute("subjectList", subjectList);
		}
		
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("student_mylogin")) {
			dispatcherUrl = "/jsp/Student/st_mylogin.jsp"; 
		}else if(action.equals("student_user_update")) {
			
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}	
}

