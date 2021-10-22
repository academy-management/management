package mjh;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "ManageController", urlPatterns = { "/student_search"})
public class ManageController extends HttpServlet{
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
	    
	    
	    if(action.equals("student_search")) { 
	    	StudentDao dao = new StudentDaoImpl();
			List<Student> studentList = dao.selectAll();

			req.setAttribute("studentList", studentList);
	    }
	    
	    String dispatcherUrl= null;
	    
	    if(action.equals("student_search")) {
	    	dispatcherUrl = "/mjh/p26.jsp";
	    }
	    
	    RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
	    dispatcher.forward(req, resp);
	}
	
}
