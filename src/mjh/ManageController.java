package mjh;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "ManageController", urlPatterns = {"/student_search","/student_update","/student_insert","/professor_search","/professor_insert","/subject_search","/subject_insert"})
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
			
	    }else if(action.equals("student_update")){
	    	String state = req.getParameter("state");
	    	int sno = Integer.parseInt(req.getParameter("sno"));
	    	    	
	    	StudentDao dao = new StudentDaoImpl();
	    	dao.update(sno, state);
	    	
			List<Student> studentList = dao.selectAll();
			req.setAttribute("studentList", studentList);
	    	
	    }else if(action.equals("student_insert")){
	    	
	    	if(req.getParameter("sno")!=null) {
	    	int sno = Integer.parseInt(req.getParameter("sno"));
			String password = req.getParameter("password");
			String name = req.getParameter("name");
			String d_name = req.getParameter("d_name");
			int year = Integer.parseInt(req.getParameter("year"));
			String tel = req.getParameter("tel");
			String email1 = req.getParameter("email");
			String email2 = req.getParameter("email2");
			String email = email1+"@"+email2;
		
			
			String address2 = req.getParameter("address2");
			String address3 = req.getParameter("address3");
			String address = address2+" "+address3;
			Student student = new Student(sno,name,year,d_name,tel,password,address,email);
			
			StudentDao dao = new StudentDaoImpl();
			dao.insert(student);
	    	}
			
	    }else if(action.equals("professor_search")){
	    	
	    }else if(action.equals("professor_insert")){
	    	
	    }else if(action.equals("subject_search")){
	    	
	    }else if(action.equals("subject_insert")){
	    	
	    }
	    
	    String dispatcherUrl= null;
	    
	    if(action.equals("student_search")) {
	    	dispatcherUrl = "/mjh/p25.jsp";
	    }else if(action.equals("student_update")){
	    	dispatcherUrl = "/mjh/p25.jsp";
	    }else if(action.equals("student_insert")){
	    	dispatcherUrl = "/mjh/p26.jsp";
	    }else if(action.equals("professor_search")){
	    	dispatcherUrl = "/mjh/p27.jsp";
	    }else if(action.equals("professor_insert")){
	    	dispatcherUrl = "/mjh/p28.jsp";
	    }else if(action.equals("subject_search")){
	    	dispatcherUrl = "/mjh/p29.jsp";
	    }else if(action.equals("subject_insert")){
	    	dispatcherUrl = "/mjh/p30.jsp";
	    }
	    
	    RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
	    dispatcher.forward(req, resp);
	}
	
}
