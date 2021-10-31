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

import dao.Professor.ProfessorDao2;
import dao.Professor.ProfessorDaoImpl2;
import dao.notice.NoticeDao;
import dao.notice.NoticeDaoImpl;
import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import model.Manager;
import model.Notice;
import model.Professor;
import model.Student;
import model.Subject;

@WebServlet(urlPatterns = {"/student_mylogin","/student_myloginpage","/student_user_detail","/student_user_update","/student_score","/student_searched","/student_class","/student_class_search", "/professor_url","/professor_searcheds"})
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
	
			String email = Student.getEmail();
			String target2 = "@";
			int targetNum2 = email.lastIndexOf(target2);
			
			String email1 = email.substring(0, targetNum2);
			String email2 = email.substring(targetNum2 + 1); 
			
			if(password.equals(Student.getPassword())) {
				StudentDao dao = new StudentDaoImpl();
				Student student = dao.selectByuser(Student.getSno());
				req.setAttribute("student", student);
				req.setAttribute("email1", email1);
				req.setAttribute("email2", email2);
				
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
			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("member");
			
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectYear(2021,2,student.getSno());
			
			req.setAttribute("subjectList", subjectList);
			
		}else if(action.equals("student_searched")) {
			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("member");
			
			int year = Integer.parseInt(req.getParameter("years"));
			int semester = Integer.parseInt(req.getParameter("semester"));
			
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectYear(year,semester,student.getSno());
			
			req.setAttribute("subjectList", subjectList);

		}else if(action.equals("student_class")) {
			
			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("member");
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectYear2(2021, 2,student.getSno());
			System.out.println(subjectList);
			req.setAttribute("subjectList", subjectList);
		}
		else if(action.equals("student_class_search")) {
			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("member");
			int year = Integer.parseInt(req.getParameter("years"));
			int semester = Integer.parseInt(req.getParameter("semester"));
			
			StudentDao dao = new StudentDaoImpl();
			List<Subject> subjectList = dao.subjectYear2(year, semester,student.getSno());
			System.out.println(subjectList);
			req.setAttribute("subjectList", subjectList);
			
		}
		else if(action.equals("professor_url")) {
			
			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("member");
			int professor_ch = 0; 
			if(student.getD_name().equals("컴퓨터공학과")){
				professor_ch=1;
			}else if(student.getD_name().equals("경영학과")) {
				professor_ch=2;
			}else if(student.getD_name().equals("화학과")) {
				professor_ch=3;
			}
			
			
			
			ProfessorDao2 dao = new ProfessorDaoImpl2();
			List<Professor> professorList = dao.Professordep(professor_ch);
			
			req.setAttribute("professorList", professorList);
			
			
		}else if(action.equals("professor_searcheds")) {
			int professor_ch = Integer.parseInt(req.getParameter("professor_ch"));
			
			ProfessorDao2 dao = new ProfessorDaoImpl2();
			List<Professor> professorList = dao.Professordep(professor_ch);
			
			req.setAttribute("professorList", professorList);

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
		
		else if(action.equals("professor_url")) {
			dispatcherUrl = "/jsp/Student/st_professor.jsp"; 
		}else if(action.equals("professor_searcheds")) {
			dispatcherUrl = "/jsp/Student/st_professor.jsp"; 

		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}	
}

