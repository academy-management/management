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

import dao.subject.SubjectDao2;
import dao.subject.SubjectDaoImpl2;
import model.Student;
import model.Subject;

@WebServlet(urlPatterns = {"/student_application", "/student_subject_select"} )
public class StudentController2 extends HttpServlet{
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
		
		if(action.equals("student_application")) {
			
			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("member");
	
			int dno = student.getDno();
			System.out.println(dno);
			SubjectDao2 dao = new SubjectDaoImpl2();
			List<Subject> subjectList = dao.selectAll(dno);
		
			req.setAttribute("subjectList", subjectList);
			session.setAttribute("subjectList", subjectList);
			
		
		} else if(action.equals("student_subject_select")) {
			
			System.out.println("Controller!");
			
			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("member");
			
			int dno = student.getDno();
			System.out.println(dno);
			String grade = req.getParameter("grade");
			String division = req.getParameter("division");
			
			System.out.println("======> " + division);
			
			List<Subject> subjectList = null;
			
			
			
			if (grade.equals("0") && division != null) {
				
				SubjectDao2 dao = new SubjectDaoImpl2();
				subjectList = dao.selectByDivision(division, dno);
		
			} else if(grade.equals("0") && division == null) {
				
				SubjectDao2 dao = new SubjectDaoImpl2();
				subjectList = dao.selectAll(dno);
				
			} else {
				
				SubjectDao2 dao = new SubjectDaoImpl2();
				subjectList = dao.selectByDivisionAndGrade(division, dno, grade);
				
				for (Subject subject : subjectList) {
					System.out.println(subject.getName());
				}

			} 

			req.setAttribute("searchGrade", grade);
			req.setAttribute("searchDivision", division);
			req.setAttribute("subjectList", subjectList);
			session.setAttribute("subjectList", subjectList);
			
			
		}

		String dispatcherUrl = null;
		
		if(action.equals("student_application")) {
		
			dispatcherUrl = "/jsp/Student/st_application.jsp"; 
			
		} else if(action.equals("student_subject_select")) {
			
			dispatcherUrl = "/jsp/Student/st_application.jsp"; 
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);

	}
}
