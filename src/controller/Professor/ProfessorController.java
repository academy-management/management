package controller.Professor;

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
import dao.subject.SubjectDao;
import dao.subject.SubjectDaoImpl;

import dao.student.StudentDao22;
import dao.student.StudentDaoImpl22;
import dao.subject.SubjectDao2;
import dao.subject.SubjectDaoImpl2;

import model.Professor;
import model.Student;
import model.Subject;



@WebServlet(urlPatterns = {"/studentSearch", "/studentNameOrYearSearch", "/studentAllSearch",
		"/studentDetail", "/studentScoreManage", "/studentScoreUpdate"})
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
		HttpSession session = req.getSession();
		Professor professor = (Professor) session.getAttribute("member");
		
	if(action.equals("studentSearch")) {
			StudentDao dao = new StudentDaoImpl();
			req.setAttribute("studentList", dao.selectByPno(professor.getDno()));
			System.out.println(professor.getDno());
		} else if(action.equals("studentNameOrYearSearch")) {
			StudentDao dao = new StudentDaoImpl();
			if("" != req.getParameter("nameSearch")) {
				req.setAttribute("studentList", dao.selectName(professor.getDno(), req.getParameter("nameSearch")));
			}else {
				req.setAttribute("studentList", dao.selectYear(professor.getDno(), req.getParameterValues("yearSelect")[0]));
			}			
		} else if(action.equals("studentDetail")) {
			StudentDao dao = new StudentDaoImpl();
			req.setAttribute("student", dao.selectByNo(req.getParameter("sno")));
		} else if(action.equals("studentScoreManage")) {
			SubjectDao subDao = new SubjectDaoImpl();
			req.setAttribute("subjectList", subDao.selectByPno(professor.getPno()));
			StudentDao stdDao = new StudentDaoImpl();
			System.out.println((req.getParameter("subjectSelect")));
			req.setAttribute("studentList", stdDao.selectBySubjectNo(req.getParameter("subjectSelect")));
					
		} else if(action.equals("studentScoreUpdate")) {
			SubjectDao subDao = new SubjectDaoImpl();
			req.setAttribute("subjectList", subDao.selectByPno(professor.getPno()));
			
			StudentDao stdDao = new StudentDaoImpl();
			System.out.println(req.getParameter("score"));
			System.out.println(req.getParameter("regno"));
			stdDao.updateToScore(req.getParameter("regno"), req.getParameter("score"));	
		}


		String dispatcherUrl = null;
		
		if(action.equals("studentSearch")) {
			dispatcherUrl = "/jsp/Professor/professorStudentSearch.jsp";
		} else if(action.equals("studentNameOrYearSearch")) {
			dispatcherUrl = "/jsp/Professor/professorStudentSearch.jsp";
		} else if(action.equals("studentDetail")) {
			dispatcherUrl = "/jsp/Professor/professorStudentDetail.jsp";
		} else if(action.equals("studentScoreManage")) {
			dispatcherUrl = "/jsp/Professor/professorStudentScoreManage.jsp";
		} else if(action.equals("studentScoreUpdate")) {
			dispatcherUrl = "/jsp/Professor/professorStudentScoreManage.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);	
	}
}
