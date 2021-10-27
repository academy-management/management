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

<<<<<<< HEAD
import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import dao.subject.SubjectDao;
import dao.subject.SubjectDaoImpl;
=======
import dao.student.StudentDao22;
import dao.student.StudentDaoImpl22;
import dao.subject.SubjectDao2;
import dao.subject.SubjectDaoImpl2;
>>>>>>> branch 'main' of https://github.com/academy-management/management.git
import model.Professor;
import model.Student;
import model.Subject;


<<<<<<< HEAD
@WebServlet(urlPatterns = {"/professorMylogin","/professorMypage", "/updateProfessorInfo", "/studentSearch", "/studentNameOrYearSearch", "/studentAllSearch",
							"/studentDetail", "/studentScoreManage"})
=======
@WebServlet(urlPatterns = {"/professorMylogin","/professorMypage", "/updateProfessorInfo", "/professorLectureInfo", "/professorLectureInfoBySelect", "/professorLectureSituation"})
>>>>>>> branch 'main' of https://github.com/academy-management/management.git
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
			
			
			
		} else if(action.equals("professorLectureInfo")) {

			HttpSession session = req.getSession();
			Professor professor = (Professor)session.getAttribute("member");
			
<<<<<<< HEAD
		} else if(action.equals("studentSearch")) {
			StudentDao dao = new StudentDaoImpl();
			req.setAttribute("studentList", dao.selectAll());
		} else if(action.equals("studentNameOrYearSearch")) {
			StudentDao dao = new StudentDaoImpl();
			if("" != req.getParameter("nameSearch")) {
				req.setAttribute("studentList", dao.selectName(req.getParameter("nameSearch")));
			}else {
				req.setAttribute("studentList", dao.selectYear(req.getParameterValues("yearSelect")[0]));
			}			
		} else if(action.equals("studentDetail")) {
			StudentDao dao = new StudentDaoImpl();
			req.setAttribute("student", dao.selectByNo(req.getParameter("sno")));
		} else if(action.equals("studentScoreManage")) {
			SubjectDao subDao = new SubjectDaoImpl();
			req.setAttribute("subjectList", subDao.selectAll());
			StudentDao stdDao = new StudentDaoImpl();
			req.setAttribute("studentList", stdDao.selectBySubjectNo("1"));
//			req.getParameterValues("subjectSelect")[0]
=======
			String pno = professor.getPno();
			
			System.out.println(pno);
			
			SubjectDao2 dao = new SubjectDaoImpl2();
			List<Subject> subjectList = dao.selectByPno(pno);
			
			if(!subjectList.isEmpty()) {
				
				req.setAttribute("subjectList", subjectList);
			
			} else {
				
				req.setAttribute("message", "등록된 강의가 없습니다");
			}
			
		} else if(action.equals("professorLectureInfoBySelect")) {
			
			HttpSession session = req.getSession();
			Professor professor = (Professor)session.getAttribute("member");
			
			String pno = professor.getPno();
			
			int year = Integer.parseInt(req.getParameter("year"));
			int semester = Integer.parseInt(req.getParameter("semester"));
			System.out.println(year);
			System.out.println(semester);
			 
			SubjectDao2 dao = new SubjectDaoImpl2();
			List<Subject> subjectList = dao.selectByRegisterYearAndSemester(pno, year, semester);
			
			if(!subjectList.isEmpty()) {
			
				req.setAttribute("subjectList", subjectList);
			
			} else {
				
				req.setAttribute("message", "등록된 강의가 없습니다");
			}
			
		} else if(action.equals("professorLectureSituation")) {
			
			int subno = Integer.parseInt(req.getParameter("subno"));
			
			SubjectDao2 subDao = new SubjectDaoImpl2();
			StudentDao22 dao = new StudentDaoImpl22();
			
			Subject subject = (Subject) subDao.selectBySubno(subno);
			List<Student> studentList = dao.selectBySubno(subno);
			
			if(!studentList.isEmpty()) {
				
				req.setAttribute("subject", subject);
				req.setAttribute("studentList", studentList);
			
			} else {
				
				req.setAttribute("subject", subject);
				req.setAttribute("message", "수강 중인 학생이 없습니다");
			}
>>>>>>> branch 'main' of https://github.com/academy-management/management.git
			
		}
		
<<<<<<< HEAD

=======
>>>>>>> branch 'main' of https://github.com/academy-management/management.git
		String dispatcherUrl = null;
		
		if(action.equals("professorMylogin")) {
			
			dispatcherUrl = "/jsp/Professor/professorMylogin.jsp";
			
<<<<<<< HEAD
		} else if(action.equals("studentSearch")) {
			dispatcherUrl = "/jsp/Professor/professorStudentSearch.jsp";
		} else if(action.equals("studentNameOrYearSearch")) {
			dispatcherUrl = "/jsp/Professor/professorStudentSearch.jsp";
		} else if(action.equals("studentDetail")) {
			dispatcherUrl = "/jsp/Professor/professorStudentDetail.jsp";
		} else if(action.equals("studentScoreManage")) {
			dispatcherUrl = "/jsp/Professor/professorStudentScoreManage.jsp";
=======
		} else if(action.equals("updateProfessorInfo")) {
			
		} else if(action.equals("professorLectureInfo") || action.equals("professorLectureInfoBySelect")) {
			
			dispatcherUrl = "/jsp/Professor/professor_lecture_info.jsp";
		
		} else if(action.equals("professorLectureSituation")) {
			
			dispatcherUrl = "/jsp/Professor/professor_lecture_situation.jsp";
			
>>>>>>> branch 'main' of https://github.com/academy-management/management.git
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);	
	}
}
