package controller.Manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Professor.ProfessorDao;
import dao.Professor.ProfessorDaoImpl;
import dao.notice.NoticeDao;
import dao.notice.NoticeDaoImpl;
import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import dao.subject.SubjectDao;
import dao.subject.SubjectDaoImpl;
import model.Notice;
import model.Professor;
import model.Student;
import model.Subject;
import page.PageDao;
import page.PageDaoImpl;
import page.PageGroupResult;
import page.PageManager;



@WebServlet(name = "ManageController", urlPatterns = {"/student_search","/student_searchbyname","/student_update","/student_insert","/professor_search","/professor_insert","/professor_update","/professor_searchbyname","/subject_search","/subject_searchNS","/subject_insert","/subject_detail","/subject_update","/manager_notice","/manager_notice_search","/manager_notice_detail","/manager_notice_insert","/manager_notice_delete","/manager_notice_update","/manager_noticeupdate"})
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
			List<Student> studentList = dao.selectByNYN("", "", "");
			req.setAttribute("studentList", studentList);
			
	    }else if(action.equals("student_searchbyname")){
	    	
	    	String name = req.getParameter("name");
			String year = req.getParameter("year");
			String department = req.getParameter("department");
			
			
			StudentDao dao = new StudentDaoImpl();
			List<Student> studentList = dao.selectByNYN(name, year, department);
			req.setAttribute("studentList", studentList);
			
			
	    }else if(action.equals("student_update")){
	    	String state = req.getParameter("state");
	    	int sno = Integer.parseInt(req.getParameter("sno"));
	    	    	
	    	StudentDao dao = new StudentDaoImpl();
	    	dao.update(sno, state);
	    	
	    	List<Student> studentList = dao.selectByNYN("", "", "");
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
			String address = address2+","+address3;
			Student student = new Student(sno,name,year,d_name,tel,password,address,email);
			
			StudentDao dao = new StudentDaoImpl();
			dao.insert(student);
	    	}
			
	    }else if(action.equals("professor_search")){
	 
	    	ProfessorDao dao = new ProfessorDaoImpl();
			List<Professor> professorlist = dao.selectAll();

			req.setAttribute("professorlist", professorlist);
			
			
	    }else if(action.equals("professor_searchbyname")){
	    	
	    	String name = req.getParameter("name");
			String department = req.getParameter("department");
			
			ProfessorDao dao = new ProfessorDaoImpl();
			List<Professor> professorlist = dao.selectByND(name, department);
			req.setAttribute("professorlist", professorlist);
			
	    }else if(action.equals("professor_insert")){
	    	if(req.getParameter("pno")!=null) {
	    		
	    		String pno = req.getParameter("pno");
				String password = req.getParameter("password");
				String name = req.getParameter("name");
				String d_name = req.getParameter("d_name");
				String major = req.getParameter("major");
				String pro_room = req.getParameter("pro_room");
				String tel = req.getParameter("tel");
				String email1 = req.getParameter("email1");
				String email2 = req.getParameter("email2");
				String email = email1+"@"+email2;
				String address2 = req.getParameter("address2");
				String address3 = req.getParameter("address3");
				String address = address2+","+address3;
				
				Professor professor = new Professor(pno,password,major,name,address,pro_room,tel,email,d_name);
				
				ProfessorDao dao = new ProfessorDaoImpl();
				dao.insert(professor);
	    	}
	    }else if(action.equals("professor_update")){
	    	
	    	String state = req.getParameter("state");
	    	String pno = req.getParameter("pno");
	    	    	
	    	ProfessorDao dao = new ProfessorDaoImpl();
	    	dao.update(pno, state);
	    	
	    	List<Professor> professorlist = dao.selectAll();
			req.setAttribute("professorlist", professorlist);
			
			
	    }else if(action.equals("subject_search")){
	    	
	    	SubjectDao dao = new SubjectDaoImpl();
			List<Subject> subjectList = dao.selectByNS("","");
			req.setAttribute("subjectList", subjectList);
			
	    }else if(action.equals("subject_searchNS")){
	    	String name = req.getParameter("name");
	    	String p_name = req.getParameter("p_name");
	    	
	    	SubjectDao dao = new SubjectDaoImpl();
			List<Subject> subjectList = dao.selectByNS(name,p_name);
			req.setAttribute("subjectList", subjectList);
			
	    }else if(action.equals("subject_insert")){
	    	if(req.getParameter("subno")!=null) {
	    	String subno = req.getParameter("subno");
			String name = req.getParameter("name");
			int grade = Integer.parseInt(req.getParameter("grade"));
			String score = req.getParameter("score");
			int people = Integer.parseInt(req.getParameter("people"));
			String room = req.getParameter("room");
			
			String time = req.getParameter("time");
			String time2 = req.getParameter("time2");
			String week = req.getParameter("week");
			String subtime = week+" "+time+"-"+time2;
			
			String startday1 = req.getParameter("startday");
			String[] startday= startday1.split((" "));
			
			String endday1 = req.getParameter("endday");
			String[] endday= endday1.split((" "));
			
			String division = req.getParameter("division");
			int dno = Integer.parseInt(req.getParameter("department"));
			String pno = req.getParameter("pno");
			
			Subject subject = new Subject( subno,  name,  grade,  score,  people,  room,  subtime,
					startday[0],  endday[0],  division,  dno,  pno);
			SubjectDao dao = new SubjectDaoImpl();
			dao.insert(subject);
			
	    	}
	    	
	    }else if(action.equals("subject_detail")){
    		String subno = req.getParameter("subno");
 
    		SubjectDao dao = new SubjectDaoImpl();
    		Subject subject = dao.select_by_subno(subno);
 
    		req.setAttribute("subject", subject);

    	}else if(action.equals("subject_update")) {
    		if(req.getParameter("subno")!=null) {
    	    	String subno = req.getParameter("subno");
    			String name = req.getParameter("name");
    			int grade = Integer.parseInt(req.getParameter("grade"));
    			String score = req.getParameter("score");
    			int people = Integer.parseInt(req.getParameter("people"));
    			String room = req.getParameter("room");
    			String state = req.getParameter("state");
    			String date = req.getParameter("date");
    			
    			SubjectDao dao = new SubjectDaoImpl();
        		Subject subject = new Subject( subno,  name,  grade,  score,  people,  room,  date, state);
        		
        		
        		System.out.println(subject);
        		dao.update(subject);
    		
    			
    		}
    			
    		
    		
    	}else if(action.equals("manager_notice")) {
    		String division = "??????";
			String searchSubject = "";

			NoticeDao dao = new NoticeDaoImpl();
			List<Notice> noticeList = null;
			
			int requestPage = 1;
			
			if(req.getParameter("reqPage") != null) {
				
				requestPage = Integer.parseInt(req.getParameter("reqPage"));
			}
			
			PageGroupResult pgr = null;
			
			
    		noticeList = dao.selectByDivision(requestPage, division);
			
			PageDao pageDao = new PageDaoImpl();
			int cnt = pageDao.getCountNoticeDivided(division);
			
			
			PageManager pm = new PageManager(requestPage);
			pgr = pm.getPageGroupResult(cnt);
			
			req.setAttribute("pageGroupResult", pgr);
			req.setAttribute("noticeList", noticeList);
    		
    	} else if(action.equals("manager_notice_search")) {
    		
    		String division = req.getParameter("division");
			String searchSubject = req.getParameter("search");

			NoticeDao dao = new NoticeDaoImpl();
			List<Notice> noticeList = null;
			
			int requestPage = 1;
			
			if(req.getParameter("reqPage") != null) {
				
				requestPage = Integer.parseInt(req.getParameter("reqPage"));
			}
			
			PageGroupResult pgr = null;
			
			/*?????? ?????? ??????*/
			if(division.equals("??????") ) {
				/*?????? ?????? + ????????? ???????????? ???????????? ????????? ???*/
				if (searchSubject == null || searchSubject.trim().isEmpty()) {
					
					noticeList = dao.selectByDivision(requestPage, division);
					
					PageDao pageDao = new PageDaoImpl();
					int cnt = pageDao.getCountNoticeDivided(division);
					
					
					PageManager pm = new PageManager(requestPage);
					pgr = pm.getPageGroupResult(cnt);
					
				/*?????? ?????? + ???????????? ????????? ???*/	
				} else {
		
					noticeList = dao.selectBySubject(requestPage, searchSubject);
					
					PageDao pageDao = new PageDaoImpl();
					int cnt = pageDao.getCountNoticeSearched(searchSubject);
					
					System.out.println(cnt);
					
					PageManager pm = new PageManager(requestPage);
					pgr = pm.getPageGroupResult(cnt);
		
				}
			/*?????? ?????? ??????*/
			} else {
				/*?????? ?????? + ????????? ???????????? ???????????? ????????? ???*/
				if(searchSubject == null || searchSubject.isEmpty()) {
					
					noticeList = dao.selectByDivision(requestPage, division);
					
					PageDao pageDao = new PageDaoImpl();
					int cnt = pageDao.getCountNoticeDivided(division);
					
					System.out.println(cnt);
					
					PageManager pm = new PageManager(requestPage);
					pgr = pm.getPageGroupResult(cnt);
					
				} else {
					/*?????? ?????? +???????????? ????????? ???*/	

					noticeList = dao.selectByDivisionAndSubject(requestPage, division, searchSubject);
					
					PageDao pageDao = new PageDaoImpl();
					int cnt = pageDao.getCountNoticeSearchedAndDivided(searchSubject, division);
					
					System.out.println(cnt);
					
					PageManager pm = new PageManager(requestPage);
					pgr = pm.getPageGroupResult(cnt);
				}
			}
			
			req.setAttribute("pageGroupResult", pgr);
			req.setAttribute("noticeList", noticeList);
    		
    	}else if(action.equals("manager_notice_detail")) {

			int nno = Integer.parseInt(req.getParameter("nno"));
			
			NoticeDao dao = new NoticeDaoImpl();
			Notice notice = dao.selectByNno(nno);
			
			int views = notice.getViews() + 1;
			dao.updateToViews(views, nno);
			
			Notice notice2 = dao.selectByNno(nno);

			req.setAttribute("notice", notice2);
			
    	}else if(action.equals("manager_notice_insert")) {
    		
    		if(req.getParameter("subject")!=null) {
    	    	
    			String subject = req.getParameter("subject");
    			String contents = req.getParameter("contents");
    			String division = req.getParameter("division");
    			
    			Notice notice = new Notice(division,subject,contents);
    			
    			NoticeDao dao = new NoticeDaoImpl();
    			dao.insert(notice);
    			
    	
    			
    			
    	    	}
    		
    	}else if(action.equals("manager_notice_delete")) {
    		
    		int nno = Integer.parseInt(req.getParameter("nno"));
    		
    		NoticeDao dao = new NoticeDaoImpl();
			dao.delete(nno);
			
    		
    	}else if(action.equals("manager_notice_update")) {
    		
    		int nno = Integer.parseInt(req.getParameter("nno"));
    		NoticeDao dao = new NoticeDaoImpl();
    		Notice notice2 = dao.selectByNno(nno);

			req.setAttribute("notice", notice2);
			
    		
    	}else if(action.equals("manager_noticeupdate")) {
    		
    		String subject = req.getParameter("subject");
    		String contents = req.getParameter("contents");
    		String division = req.getParameter("division");
    		int nno = Integer.parseInt(req.getParameter("nno"));
    		NoticeDao dao = new NoticeDaoImpl();
    		dao.update(subject, contents, division, nno);

			
    		
    	}
    		
    		
	    
	    String dispatcherUrl= null;
	    
	    if(action.equals("student_search")) {
	    	dispatcherUrl = "/jsp/Manager/manager_student_search.jsp";
	    }else if(action.equals("student_searchbyname")){
	    	dispatcherUrl = "/jsp/Manager/manager_student_search.jsp";
	    }else if(action.equals("student_update")){
	    	dispatcherUrl = "/jsp/Manager/manager_student_search.jsp";
	    }else if(action.equals("student_insert")){
	    	dispatcherUrl = "/jsp/Manager/manager_student_insert.jsp";
	    }else if(action.equals("professor_search")){
	    	dispatcherUrl = "/jsp/Manager/manager_professor_search.jsp";
	    }else if(action.equals("professor_searchbyname")){
	    	dispatcherUrl = "/jsp/Manager/manager_professor_search.jsp";
	    }else if(action.equals("professor_insert")){
	    	dispatcherUrl = "/jsp/Manager/manager_professor_insert.jsp";
	    }else if(action.equals("professor_update")){
	    	dispatcherUrl = "/jsp/Manager/manager_professor_search.jsp";
	    }else if(action.equals("subject_search")){
	    	dispatcherUrl = "/jsp/Manager/manager_submit_search.jsp";
	    }else if(action.equals("subject_searchNS")){
	    	dispatcherUrl = "/jsp/Manager/manager_submit_search.jsp";
	    }else if(action.equals("subject_insert")){
	    	dispatcherUrl = "/jsp/Manager/manager_submit_insert.jsp";
	    }else if(action.equals("subject_detail")){
	    	dispatcherUrl = "/jsp/Manager/manager_submit_detail.jsp";
	    }else if(action.equals("subject_update")) {
	    	dispatcherUrl = "subject_search";
	    }else if(action.equals("manager_notice")) {
	    	dispatcherUrl = "/jsp/Manager/manager_Notice.jsp";
    	}else if(action.equals("manager_notice_search")) {
	    	dispatcherUrl = "/jsp/Manager/manager_Notice.jsp";
    	}else if(action.equals("manager_notice_detail")) {
    		dispatcherUrl = "/jsp/Manager/manager_NoticeDetail.jsp";
    	}else if(action.equals("manager_notice_insert")) {
    		dispatcherUrl = "/jsp/Manager/manager_notice_insert.jsp";
    	}else if(action.equals("manager_notice_delete")) {
    		dispatcherUrl = "manager_notice";
    	}else if(action.equals("manager_notice_update")) {
    		dispatcherUrl = "/jsp/Manager/manager_notice_update.jsp";
    	}else if(action.equals("manager_noticeupdate")) {
    		dispatcherUrl = "manager_notice";
    	}
	    
	    RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
	    dispatcher.forward(req, resp);
	}
	
}
