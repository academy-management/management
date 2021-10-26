package jmj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jmj.SutudentDao;
import dao.jmj.SutudentImpl;

@WebServlet(name = "NoticeController", urlPatterns= {"/memo_detail"})
public class NoticeController extends HttpServlet{
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
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);//�� �ε������� ���� �ؼ� ���� �� ������
		
		
		if(action.equals("memo_detail")) {
			
			int Nno = Integer.parseInt(req.getParameter("Nno"));
			
			SutudentDao dao = new SutudentImpl();
			Notice notice = dao.selectBymemoid(Nno);
			
			req.setAttribute("memo", notice);
			
		}
		String dispatcherUrl = null; 
		
		if(action.equals("memo_detail")) {
			dispatcherUrl = "/detail.jsp";	
			
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp); 
		
		
		
	}
}
