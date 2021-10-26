package jmj;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;

@WebServlet(name="LoginController", urlPatterns= {"/login","/login_out","/mylogin","/user_detail"})
public class LoginControllerjmj extends HttpServlet{
	
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
		if(action.equals("login")) {
			int sno = Integer.parseInt(req.getParameter("sno"));
			String pw = req.getParameter("password");
			
			SutudentDao dao = new SutudentImpl();
	
			Student student = (Student) dao.login(sno,pw);
			
			if(student != null) {
				HttpSession session= req.getSession();
				session.setAttribute("member", student); 
			}else {
				req.setAttribute("message", "존재하지 않는 아이디 이거나 비밀전호가 일치 하지않습니다.");
			}
		}else if(action.equals("login_out")) {
			HttpSession session= req.getSession();
			session.removeAttribute("member");
		}else if(action.equals("mylogin")) {
			String pw = req.getParameter("password");
			
			SutudentDao dao = new SutudentImpl();
			
			Student student = dao.mylogin(pw);
			
			if(student != null) {
				HttpSession session= req.getSession();
				session.setAttribute("member", student); 
			}else {
				req.setAttribute("message", "비밀번호가 일치 하지않습니다.");
			}
		}else if(action.equals("user_detail")) {
			
			
		}
		
		
		//페이지
		String dispatcherUrl = null; 
		if(action.equals("login")) { 
			HttpSession session= req.getSession();
			
//			SutudentDao dao = new SutudentImpl();
//			List<SystemMaster> smList = dao.selectDepCode();
//			System.out.println("smList         "+smList);
//			
//			req.setAttribute("smList", smList);
			
			if(session.getAttribute("member") != null) {
				dispatcherUrl = "/01main.jsp"; 
			}else {
				dispatcherUrl = "/00login.jsp"; 
			}
			
		}else if(action.equals("login_out")) {
			dispatcherUrl = "/00login.jsp"; 
		}else if(action.equals("mylogin")) {
			HttpSession session= req.getSession();
			if(session.getAttribute("member") != null) {
				dispatcherUrl = "/02mylogin.jsp"; 
			}
			
		}else if(action.equals("user_detail")) {
			dispatcherUrl = "/03mypage.jsp"; 
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}	
}
