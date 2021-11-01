package controller.Login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Professor.ProfessorDao;
import dao.Professor.ProfessorDaoImpl;
import dao.manager.ManagerDao;
import dao.manager.ManagerDaoImpl;
import dao.notice.NoticeDao;
import dao.notice.NoticeDaoImpl;
import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import model.Manager;
import model.Notice;
import model.Professor;
import model.Student;


@WebServlet(urlPatterns = {"/login_input", "/login", "/logout","/studentmain"})
public class loginController extends HttpServlet{
	
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
		if(action.equals("login_input")) {
			
		} else if(action.equals("login")) {
			
			if(req.getParameter("loginselect").equals("ps")) {
			String pno = req.getParameter("pno");
			String password = req.getParameter("password");
				
			ProfessorDao dao = new ProfessorDaoImpl();
			Professor professor = dao.selectByPno(pno);
			
			if(professor != null) {
			
				if(professor.getPassword().equals(password)) {
	
					HttpSession session = req.getSession();
					session.setAttribute("member", professor);
											
					NoticeDao ndao = new NoticeDaoImpl();
					List<Notice> noticeList = ndao.selectAll(1);
						
					req.setAttribute("noticeList", noticeList);
					dispatcherUrl = "/jsp/Professor/professor_main.jsp";
						
				} else {
						
					req.setAttribute("message", "비밀번호가 일치하지 않습니다.");
					dispatcherUrl = "/index.jsp";
				}
				
			} else {
				

				req.setAttribute("message", "존재하지 않는 아이디,비밀번호입니다.");
				dispatcherUrl = "/index.jsp";
				
			}
			
			}else if(req.getParameter("loginselect").equals("st")) {
				
				int pno = Integer.parseInt(req.getParameter("pno"));
				String password = req.getParameter("password");
					
				StudentDao dao = new StudentDaoImpl();
				Student student = dao.selectByuser(pno);
				//Student student2 = dao.selectByuser(pno);
				
				if(student != null) {
				
					if(student.getPassword().equals(password)) {
		
						HttpSession session = req.getSession();
						session.setAttribute("member", student);
												
						NoticeDao ndao = new NoticeDaoImpl();
						List<Notice> noticeList = ndao.selectAll(1);
							
						req.setAttribute("noticeList", noticeList);
						dispatcherUrl = "/jsp/Student/st_main.jsp";
							
					} else {
							
						req.setAttribute("message", "비밀번호가 일치하지 않습니다.");
						dispatcherUrl = "/index.jsp";
					}
					
				} else {
					
					req.setAttribute("message", "존재하지 않는 아이디,비밀번호입니다.");
					dispatcherUrl = "/index.jsp";
				}
				
			}else if(req.getParameter("loginselect").equals("ad")) {
				
				String pno = req.getParameter("pno");
				String password = req.getParameter("password");
					
				ManagerDao dao = new ManagerDaoImpl();
				Manager manager = dao.selectById(pno);
				
				if(manager != null) {
				
					if(manager.getPassword().equals(password)) {
		
						HttpSession session = req.getSession();
						session.setAttribute("member", manager);
												
						NoticeDao ndao = new NoticeDaoImpl();
						List<Notice> noticeList = ndao.selectAll(1);
							
						req.setAttribute("noticeList", noticeList);
						dispatcherUrl = "/jsp/Manager/manager_main.jsp";
							
					} else {
							
						req.setAttribute("message", "비밀번호가 일치하지 않습니다.");
						dispatcherUrl = "/index.jsp";
					}
					
				} else {
					
					req.setAttribute("message", "존재하지 않는 아이디,비밀번호입니다.");
					dispatcherUrl = "/index.jsp";
					
				}
			}
			
		

			
		} else if(action.equals("professor_logout")) {
			
			HttpSession session = req.getSession();
			session.removeAttribute("member");
			
		}else if(action.equals("studentmain")) {
			
			
		NoticeDao ndao = new NoticeDaoImpl();
		List<Notice> noticeList = ndao.selectAll(1);
			
		req.setAttribute("noticeList", noticeList);
		dispatcherUrl = "/jsp/Professor/professor_main.jsp";
		}
		
		
		
		if(action.equals("login_input")) {
			
			dispatcherUrl = "/index";
			
		} else if(action.equals("login")) {
			
			HttpSession session = req.getSession();
			if(session.getAttribute("member") == null) {
				dispatcherUrl = "/index.jsp";
			}
			
			

		} else if(action.equals("logout")) {
			
			dispatcherUrl = "/index.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);

	}
}
