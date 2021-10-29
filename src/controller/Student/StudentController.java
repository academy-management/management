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

import dao.notice.NoticeDao;
import dao.notice.NoticeDaoImpl;
import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import model.Notice;
import model.Student;
import model.Subject;

@WebServlet(urlPatterns = {"/student_mylogin","/student_myloginpage","/student_user_detail","/student_user_update","/student_score","/student_searched","/student_class","/student_class_search"})
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
			
			String password = req.getParameter("password"); 
			HttpSession session= req.getSession();
			Student Student = (Student)session.getAttribute("member");
	
			if(password.equals(Student.getPassword())) {
				StudentDao dao = new StudentDaoImpl();
				Student student = dao.selectByuser(Student.getSno());
				req.setAttribute("student", student);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/Student/st_mypage.jsp"); 
				
				rd.forward(req, resp);
			}else {
				req.setAttribute("message", "비밀번호가 일치 하지않습니다.");
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/Student/st_mylogin.jsp");
				rd.forward(req, resp);
			}
		}
		else if(action.equals("student_user_update")) {
			
			int sno = Integer.parseInt(req.getParameter("sno"));
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			
			Student st = new Student();
			st.setName(name);
			st.setPassword(password);
			st.setTel(tel);
			st.setEmail(email);	
			st.setAddress(address);
			st.setSno(sno);
			
			
			StudentDao dao = new StudentDaoImpl();
			dao.studentUpdate(st);
			
		}else if(action.equals("student_score")) {
			
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectAll();
			
			req.setAttribute("subjectList", subjectList);
			
		}else if(action.equals("student_searched")) {
			int year = Integer.parseInt(req.getParameter("years"));
			int semester = Integer.parseInt(req.getParameter("semester"));
			
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectYear(year,semester);
			
			req.setAttribute("subjectList", subjectList);
			
		}else if(action.equals("student_class_search")) {
			int year = Integer.parseInt(req.getParameter("years"));
			int semester = Integer.parseInt(req.getParameter("semester"));
			
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectYear(year,semester);
			
			req.setAttribute("subjectList", subjectList);
			
		}else if(action.equals("student_class")) {
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectAllClass();
			
			req.setAttribute("subjectList", subjectList);
		}
		
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("student_mylogin")) {
			dispatcherUrl = "/jsp/Student/st_mylogin.jsp"; 
		}else if(action.equals("student_user_update")) {
			NoticeDao ndao = new NoticeDaoImpl();
			List<Notice> noticeList = ndao.selectAll(1);
				
			req.setAttribute("noticeList", noticeList);
			dispatcherUrl = "/jsp/Student/st_main.jsp";
			
		}else if(action.equals("student_score")) {
			dispatcherUrl = "/jsp/Student/st_score.jsp"; 
		}else if(action.equals("student_searched")) {
			dispatcherUrl = "/jsp/Student/st_score.jsp"; 
		}else if(action.equals("student_class")) {
			dispatcherUrl = "/jsp/Student/st_lecture.jsp"; 
		}else if(action.equals("student_class_search")) {
			dispatcherUrl = "/jsp/Student/st_lecture.jsp"; 
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}	
}

