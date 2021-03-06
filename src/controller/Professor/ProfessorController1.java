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

import dao.Professor.ProfessorDao2;
import dao.Professor.ProfessorDaoImpl2;
import dao.notice.NoticeDao;
import dao.notice.NoticeDaoImpl;
import dao.student.StudentDao22;
import dao.student.StudentDaoImpl22;
import dao.subject.SubjectDao2;
import dao.subject.SubjectDaoImpl2;
import model.Notice;
import model.Professor;
import model.Student;
import model.Subject;

@WebServlet(urlPatterns = {"/professorMylogin", "/professorMypage", "/updateProfessorInfo", "/professorLectureInfo", "/professorLectureInfoBySelect", "/professorLectureSituation"})
public class ProfessorController1 extends HttpServlet{
	
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
		String dispatcherUrl = null;
		
		if(action.equals("professorMylogin")) {
			
			
		} else if(action.equals("professorMypage")) {
			
			String passwordCheck = req.getParameter("password");
			
			HttpSession session = req.getSession();
			Professor professor = (Professor) session.getAttribute("member");
			
			System.out.println(professor.toString());
			
			String address = professor.getAddress();
			String target1 = ",";
			int targetNum = address.lastIndexOf(target1);
			
			String address1 = address.substring(0,targetNum);
			String address2 = address.substring(targetNum + 1);
			
			String email = professor.getEmail();
			String target2 = "@";
			int targetNum2 = email.lastIndexOf(target2);
			
			String email1 = email.substring(0, targetNum2);
			String email2 = email.substring(targetNum2 + 1); 
			
			/*System.out.println(address1);
			System.out.println(address2);
			
			*/
			if(passwordCheck.equals(professor.getPassword())) {
				
				req.setAttribute("professor", professor);
				req.setAttribute("address1", address1);
				req.setAttribute("address2", address2);
				req.setAttribute("email1", email1);
				req.setAttribute("email2", email2);
				
				dispatcherUrl = "/jsp/Professor/professor_mypage.jsp";
				
			} else {
				
				req.setAttribute("message", "????????? ???????????? ?????????");
				
				dispatcherUrl = "/jsp/Professor/professor_mylogin.jsp";
			}
			
		} else if(action.equals("updateProfessorInfo")) {
			
			String pno = req.getParameter("pno");
			String d_name = req.getParameter("dname");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String address = req.getParameter("address1") + "," + req.getParameter("address2");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email1") + "@" + req.getParameter("email3");
			
			System.out.println("====> check address : " + address);
			
			Professor professor = new Professor();
			professor.setPno(pno);
			professor.setD_name(d_name);
			professor.setName(name);
			professor.setPassword(password);
			professor.setAddress(address);
			professor.setTel(tel);
			professor.setEmail(email);
			
			ProfessorDao2 dao = new ProfessorDaoImpl2();
			dao.update(professor);			
			NoticeDao ndao = new NoticeDaoImpl();
            List<Notice> noticeList = ndao.selectAll(1);
            req.setAttribute("noticeList", noticeList);
			HttpSession session = req.getSession();
			session.removeAttribute("memeber");
			session.setAttribute("member", professor); 

		} else if(action.equals("professorLectureInfo")) {

			HttpSession session = req.getSession();
			Professor professor = (Professor)session.getAttribute("member");
			
			String pno = professor.getPno();
			
			SubjectDao2 dao = new SubjectDaoImpl2();
			List<Subject> subjectList = dao.selectByPno(pno);
			
			if(!subjectList.isEmpty()) {
			
				req.setAttribute("subjectList", subjectList);
			
			} else {
				
				req.setAttribute("message", "????????? ????????? ????????????");
			}
			
		} else if(action.equals("professorLectureInfoBySelect")) {
			
			HttpSession session = req.getSession();
			Professor professor = (Professor)session.getAttribute("member");
			
			String pno = professor.getPno();
			
			int year = Integer.parseInt(req.getParameter("year"));
			int semester = Integer.parseInt(req.getParameter("semester"));
		
			SubjectDao2 dao = new SubjectDaoImpl2();
			List<Subject> subjectList = dao.selectByRegisterYearAndSemester(pno, year, semester);
			
			System.out.println(year);
			System.out.println(semester);
			
			req.setAttribute("searchYear", year);
			req.setAttribute("searchSemester", semester);
			
			if(!subjectList.isEmpty()) {
			
				req.setAttribute("subjectList", subjectList);
			
			} else {
				
				req.setAttribute("message", "????????? ????????? ????????????");
			}
			
		} else if(action.equals("professorLectureSituation")) {
			
			 String subno = req.getParameter("subno");
			
			SubjectDao2 subDao = new SubjectDaoImpl2();
			StudentDao22 dao = new StudentDaoImpl22();
			
			Subject subject = (Subject) subDao.selectBySubno(subno);
			List<Student> studentList = dao.selectBySubno(subno);
			
			if(!studentList.isEmpty()) {
				
				req.setAttribute("subject", subject);
				req.setAttribute("studentList", studentList);
			
			} else {
				
				req.setAttribute("subject", subject);
				req.setAttribute("message", "?????? ?????? ????????? ????????????");
			}

			
		}
		
		
		
		if(action.equals("professorMylogin")) {
			
			dispatcherUrl = "/jsp/Professor/professor_mylogin.jsp";

		} else if(action.equals("updateProfessorInfo")) {
			
			dispatcherUrl = "/jsp/Professor/professor_main.jsp";
			
		} else if(action.equals("professorLectureInfo") || action.equals("professorLectureInfoBySelect")) {
			
			dispatcherUrl = "/jsp/Professor/professor_lecture_info.jsp";
		
		} else if(action.equals("professorLectureSituation")) {
			
			dispatcherUrl = "/jsp/Professor/professor_lecture_situation.jsp";
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);	
	}
}