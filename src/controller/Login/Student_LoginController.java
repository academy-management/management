package controller.Login;

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

@WebServlet(name="LoginController", urlPatterns= {"/student_login","/student_login_out","/student_mylogin","/student_user_detail"})
public class Student_LoginController extends HttpServlet{
	
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
		if(action.equals("student_login")) {
			int sno = Integer.parseInt(req.getParameter("sno"));
			String pw = req.getParameter("password");
			
			StudentDao dao = new StudentDaoImpl();
	
			Student student = (Student) dao.login(sno,pw);
			
			if(student != null) {
				HttpSession session= req.getSession();
				session.setAttribute("member", student); 
			}else {
				req.setAttribute("message", "존재하지 않는 아이디 이거나 비밀전호가 일치 하지않습니다.");
			}
		}else if(action.equals("student_login_out")) {
			HttpSession session= req.getSession();
			session.removeAttribute("member");
		}else if(action.equals("student_mylogin")) {
			String pw = req.getParameter("password");
			
			StudentDao dao = new StudentDaoImpl();
			
			Student student = dao.mylogin(pw);
			
			if(student != null) {
				HttpSession session= req.getSession();
				session.setAttribute("member", student); 
			}else {
				req.setAttribute("message", "비밀번호가 일치 하지않습니다.");
			}
		}else if(action.equals("student_user_detail")) {
			
			
		}
		
		
		//페이지
		String dispatcherUrl = null; 
		if(action.equals("student_login")) { 
			HttpSession session= req.getSession();
			
//			SutudentDao dao = new SutudentImpl();
//			List<SystemMaster> smList = dao.selectDepCode();
//			System.out.println("smList         "+smList);
//			
//			req.setAttribute("smList", smList);
			
			if(session.getAttribute("member") != null) {
				dispatcherUrl = "/01main.jsp"; 
			}else {
				dispatcherUrl = "/00login.jsp"; 
			}
			
		}else if(action.equals("student_login_out")) {
			dispatcherUrl = "/00login.jsp"; 
		}else if(action.equals("student_mylogin")) {
			HttpSession session= req.getSession();
			if(session.getAttribute("member") != null) {
				dispatcherUrl = "/02mylogin.jsp"; 
			}
			
		}else if(action.equals("student_user_detail")) {
			dispatcherUrl = "/03mypage.jsp"; 
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}	
}