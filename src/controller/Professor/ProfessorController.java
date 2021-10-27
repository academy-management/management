package controller.Professor;

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
import model.Professor;


@WebServlet(urlPatterns = {"/professorMylogin","/professorMypage", "/updateProfessorInfo", "/studentSearch", "/studentNameOrYearSearch", "/studentAllSearch"})
public class ProfessorController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action =  uri.substring(lastIndex + 1);
		
		if(action.equals("professorMylogin")) {
			
			
		} else if(action.equals("professorMypage")) {
			
			String passwordCheck = req.getParameter("password");
			
			HttpSession session = req.getSession();
			Professor professor = (Professor) session.getAttribute("member");
			
			if(passwordCheck.equals(professor.getPassword())) {
				
				req.setAttribute("professor", professor);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/Professor/professorMypage.jsp");
				dispatcher.forward(req, resp);
				
			} else {
				
				req.setAttribute("message", "잘못된 비밀번호 입니다");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/Professor/professorMylogin.jsp");
				dispatcher.forward(req, resp);
			}
			
		} else if(action.equals("updateProfessorInfo")) {
			
			
			
			
		} else if(action.equals("studentSearch")) {
			StudentDao dao = new StudentDaoImpl();
			req.setAttribute("studentList", dao.selectAll());
		} else if(action.equals("studentNameOrYearSearch")) {
			StudentDao dao = new StudentDaoImpl();			
			req.setAttribute("studentList", dao.selectYear(req.getParameterValues("yearSelect")[0]));
		}
		

	String dispatcherUrl = null;
		
		if(action.equals("professorMylogin")) {
			
			dispatcherUrl = "/jsp/Professor/professorMylogin.jsp";
			
		} else if(action.equals("studentSearch")) {
			dispatcherUrl = "/jsp/Professor/professorStudentSearch.jsp";
		} else if(action.equals("studentNameOrYearSearch")) {
			dispatcherUrl = "/jsp/Professor/professorStudentSearch.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);	
	}
}
