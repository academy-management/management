package jmj;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "EmpController", urlPatterns = { "/emp_input", "/emp_save","/emp_list" ,
		"/emp_search"})
public class EmpController extends HttpServlet{
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
	    
	    
	    if(action.equals("emp_input")) { 
	    	
	    }else if(action.equals("emp_save")) {
	    	
			

	    }else if(action.equals("emp_list")) {
	    	
	    	
	    }else if(action.equals("emp_search")) {
	    	
	    	
	    
	    }  
	    String dispatcherUrl= null;
	    
	    if(action.equals("emp_input")) {
	    	dispatcherUrl = "/empjsp/empsave.jsp";
	    }else if(action.equals("emp_save")) {
	    	dispatcherUrl = "/empjsp/empsave.jsp";
	    }else if(action.equals("emp_list")) {
	    	dispatcherUrl = "/empjsp/list.jsp";
	    }else if(action.equals("emp_search")) {
	    	dispatcherUrl = "/empjsp/list.jsp";
	    }
	    
	    RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
	    dispatcher.forward(req, resp);
	}
	
}
