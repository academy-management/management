package controller.Manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.manager.ManagerDao;
import dao.manager.ManagerDaoImpl;
import dao.notice.NoticeDao;
import dao.notice.NoticeDaoImpl;
import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import model.Manager;
import model.Notice;
import model.Professor;



@WebServlet(name = "ManageloginController", urlPatterns = {"/manager_mylogin","/manager_loginpage","/manager_user_update"})
public class ManageloginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
	    
	    
	    if(action.equals("manager_loginpage")) { 
	    	
	    	String passwordCheck = req.getParameter("password");
			
			HttpSession session = req.getSession();
			Manager manager = (Manager) session.getAttribute("member");
			
			String address = manager.getAddress();
			String target1 = ",";
			int targetNum = address.lastIndexOf(target1);
			
			String address1 = address.substring(0,targetNum);
			String address2 = address.substring(targetNum + 1);
			
			String email = manager.getEmail();
			String target2 = "@";
			int targetNum2 = email.lastIndexOf(target2);
			
			String email1 = email.substring(0, targetNum2);
			String email2 = email.substring(targetNum2 + 1); 
			
			/*System.out.println(address1);
			System.out.println(address2);
			
			*/
			if(passwordCheck.equals(manager.getPassword())) {
				
				req.setAttribute("manager", manager);
				req.setAttribute("address1", address1);
				req.setAttribute("address2", address2);
				req.setAttribute("email1", email1);
				req.setAttribute("email2", email2);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/Manager/manager_mypage.jsp"); 
				
				rd.forward(req, resp);
				
			} else {
				
				req.setAttribute("message", "비밀번호가 일치 하지않습니다.");
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/Manager/manager_mylogin.jsp");
				rd.forward(req, resp);
			}
	    	
			
	    }else if(action.equals("manager_user_update")) {
	    	String id = req.getParameter("id");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			
			ManagerDao dao = new ManagerDaoImpl();
			dao.managerUpdate(id, name, password, tel, email, address);
			
			
	    }else if(action.equals("manager_mylogin")) {
	    	
	    	
	    }
    		
	    
	    String dispatcherUrl= null;
	    
	    if(action.equals("manager_loginpage")) {
	    	
	    }else if(action.equals("manager_user_update")) {
	    	NoticeDao ndao = new NoticeDaoImpl();
			List<Notice> noticeList = ndao.selectAll(1);
				
			req.setAttribute("noticeList", noticeList);
			dispatcherUrl = "/jsp/Manager/manager_main.jsp";
	    }else if(action.equals("manager_mylogin")) {
	    	dispatcherUrl = "/jsp/Manager/manager_mylogin.jsp";
	    	
	    }
    		
	    RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
	    dispatcher.forward(req, resp);
	}
	
}
