package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ihk.notice.dao.NoticeDao;
import ihk.notice.dao.NoticeDaoImpl;
import ihk.notice.model.Notice;
import ihk.professor.dao.ProfessorDao;
import ihk.professor.dao.ProfessorDaoImpl;
import ihk.professor.model.Professor;


@WebServlet(urlPatterns = {"/login_input", "/login", "/logout"})
public class LoginController extends HttpServlet{
	
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
		
		if(action.equals("login_input")) {
			
		} else if(action.equals("login")) {
			
			int pno = Integer.parseInt(req.getParameter("pno"));
			String password = req.getParameter("password");
			
			ProfessorDao dao = new ProfessorDaoImpl();
			Professor professor = dao.selectByPno(pno);
			
			
			if (professor != null) {
				
				if(professor.getPassword().equals(password)) {
					/*로그인 성공 -> 세션 생성*/
					HttpSession session = req.getSession();
					session.setAttribute("member", professor);
										
					/*로그인 성공 -> 메인에 공지 띄우기*/
					NoticeDao ndao = new NoticeDaoImpl();
					List<Notice> noticeList = ndao.selectAll(1);
					
					req.setAttribute("noticeList", noticeList);
					
				} else {
					
					req.setAttribute("massage", "비밀번호가 일치하지 않습니다.");
				}

			} else {
				
				req.setAttribute("massage", "존재하지 않는 아이디(교번)입니다.");
				
			}
			
		} else if(action.equals("logout")) {
			
			HttpSession session = req.getSession();
			session.removeAttribute("member");
			
		}

		
		String dispatcherUrl = null;
		
		if(action.equals("login_input")) {
			
			dispatcherUrl = "/ihk/11.professorLogin.jsp";
			
		} else if(action.equals("login")) {
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("member") != null) {
				
				dispatcherUrl = "/ihk/12.professorMain.jsp";
				
			} else {
				
				dispatcherUrl = "/ihk/11.professorLogin.jsp";
			}

		} else if(action.equals("logout")) {
			
			dispatcherUrl = "/ihk/00.login.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);

	}
}
