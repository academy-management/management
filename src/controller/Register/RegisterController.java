package controller.Register;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Register.RegisterDao;
import dao.Register.RegisterDaoImpl;
import model.Register;
import model.Student;
import model.Subject;


@WebServlet(urlPatterns = {"/register_student"})
public class RegisterController extends HttpServlet {
	
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
		
		if(action.equals("register_student")) {
			
			HttpSession session = req.getSession();
			Student student = (Student)session.getAttribute("member");
			
			int year = 2021;
			int semester = 2;
		
			int sno = student.getSno();
		
			String subno = req.getParameter("subno");
			
			Register register = new Register();
			
			register.setYear(year);
			register.setSemester(semester);
			register.setSno(sno);
			register.setSubno(subno);
			
			RegisterDao dao = new RegisterDaoImpl();
			dao.insert(register);
			
			ArrayList<Subject> subjectlist = (ArrayList)session.getAttribute("subjectList");
			req.setAttribute("subjectList", subjectlist );

 		}
		
		String dispatcherUrl = null;
		
		if(action.equals("register_student")) {
		
			dispatcherUrl = "/jsp/Student/st_application.jsp"; 
			
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);

	}

}
