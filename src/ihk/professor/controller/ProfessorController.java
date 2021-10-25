package ihk.professor.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ihk.professor.model.Professor;

@WebServlet(urlPatterns = {"/professorMylogin","/professorMypage", "/updateProfessorInfo"})
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
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/ihk/14.professorMypage.jsp");
				dispatcher.forward(req, resp);
				
			} else {
				
				req.setAttribute("message", "잘못된 비밀번호 입니다");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/ihk/13.professorMylogin.jsp");
				dispatcher.forward(req, resp);
			}
			
		} else if(action.equals("updateProfessorInfo")) {
			
			
			
			
		}

	String dispatcherUrl = null;
		
		if(action.equals("professorMylogin")) {
			
			dispatcherUrl = "/ihk/13.professorMylogin.jsp";
			
		} 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);	
	}
}
