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
import dao.notice.NoticeDao;
import dao.notice.NoticeDaoImpl;
import model.Notice;
import model.Professor;


@WebServlet(urlPatterns = {"/professor_login_input", "/professor_login", "/professor_logout"})
public class Professor_LoginController extends HttpServlet{
	
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
		
		if(action.equals("professor_login_input")) {
			
		} else if(action.equals("professor_login")) {
			
			String pno = req.getParameter("pno");
			String password = req.getParameter("password");
			
			ProfessorDao dao = new ProfessorDaoImpl();
			Professor professor = dao.selectByPno(pno);
			
			
			if (professor != null) {
				
				if(professor.getPassword().equals(password)) {

					HttpSession session = req.getSession();
					session.setAttribute("member", professor);
										
					NoticeDao ndao = new NoticeDaoImpl();
					List<Notice> noticeList = ndao.selectAll(1);
					
					req.setAttribute("noticeList", noticeList);
					
				} else {
					
					req.setAttribute("message", "비밀번호가 일치하지 않습니다.");
				}

			} else {
				
				req.setAttribute("message", "존재하지 않는 교번입니다");
				
			}
			
		} else if(action.equals("professor_logout")) {
			
			HttpSession session = req.getSession();
			session.removeAttribute("member");
			
		}

		
		String dispatcherUrl = null;
		
		if(action.equals("professor_login_input")) {
			
			dispatcherUrl = "/jsp/professorLogin.jsp";
			
		} else if(action.equals("professor_login")) {
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("member") != null) {
				
				dispatcherUrl = "/jsp/professorMain.jsp";
				
			} else {
				
				dispatcherUrl = "/jsp/professorLogin.jsp";
			}

		} else if(action.equals("professor_logout")) {
			
			dispatcherUrl = "/jsp/professorLogin.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);

	}
}
