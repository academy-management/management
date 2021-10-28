package controller.Notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.notice.NoticeDao;
import dao.notice.NoticeDaoImpl;
import model.Notice;
import page.PageDao;
import page.PageDaoImpl;
import page.PageGroupResult;
import page.PageManager;


@WebServlet(urlPatterns= {"/notice", "/notice_search", "/notice_detail"})
public class NoticeController extends HttpServlet {
	
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
		
		if(action.equals("notice")) {
			
			int requestPage = 1;
			
			if(req.getParameter("reqPage") != null) {
				
				requestPage = Integer.parseInt(req.getParameter("reqPage"));
			}
			
			System.out.println(requestPage);
			
			NoticeDao dao = new NoticeDaoImpl();
			List<Notice> noticeList = dao.selectAll(requestPage);	
			
			req.setAttribute("noticeList", noticeList);
			
			/*NOTICE 전체 줄 수 가져오기*/
			
			PageDao pageDao = new PageDaoImpl();
			int cnt = pageDao.getCountNotice();
			
			System.out.println(cnt);
			
			PageManager pm = new PageManager(requestPage);
			PageGroupResult pgr = pm.getPageGroupResult(cnt);
			
			req.setAttribute("pageGroupResult", pgr);
		
		} else if(action.equals("notice_search")) {

			String division = req.getParameter("division");
			String searchSubject = req.getParameter("search");

			NoticeDao dao = new NoticeDaoImpl();
			List<Notice> noticeList = null;
			
			int requestPage = 1;
			
			if(req.getParameter("reqPage") != null) {
				
				requestPage = Integer.parseInt(req.getParameter("reqPage"));
			}
			
			PageGroupResult pgr = null;
			
			/*전체 검색 클릭*/
			if(division.equals("total") ) {
				/*전체 선택 + 검색에 아무것도 입력하지 않았을 때*/
				if (searchSubject == null || searchSubject.trim().isEmpty()) {
					
					noticeList = dao.selectAll(requestPage);
					
					PageDao pageDao = new PageDaoImpl();
					int cnt = pageDao.getCountNotice();
					
					System.out.println(cnt);
					
					PageManager pm = new PageManager(requestPage);
					pgr = pm.getPageGroupResult(cnt);
					
				/*전체 선택 + 검색값을 넣었을 때*/	
				} else {
		
					noticeList = dao.selectBySubject(requestPage, searchSubject);
					
					PageDao pageDao = new PageDaoImpl();
					int cnt = pageDao.getCountNoticeSearched(searchSubject);
					
					System.out.println(cnt);
					
					PageManager pm = new PageManager(requestPage);
					pgr = pm.getPageGroupResult(cnt);
		
				}
			/*학과 검색 클릭*/
			} else {
				/*학과 선택 + 검색에 아무것도 입력하지 않았을 때*/
				if(searchSubject == null || searchSubject.isEmpty()) {
					
					noticeList = dao.selectByDivision(requestPage, division);
					
					PageDao pageDao = new PageDaoImpl();
					int cnt = pageDao.getCountNoticeDivided(division);
					
					System.out.println(cnt);
					
					PageManager pm = new PageManager(requestPage);
					pgr = pm.getPageGroupResult(cnt);
					
				} else {
					/*학과 선택 +검색값을 넣었을 때*/	

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
			
		} else if(action.equals("notice_detail")) {
			
			int nno = Integer.parseInt(req.getParameter("nno"));
			
			NoticeDao dao = new NoticeDaoImpl();
			Notice notice = dao.selectByNno(nno);
			
			int views = notice.getViews() + 1;
			dao.updateToViews(views, nno);
			
			Notice notice2 = dao.selectByNno(nno);

			req.setAttribute("notice", notice2);
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("notice")) {
			dispatcherUrl = "/jsp/Student/studentNotice.jsp";
			
		} else if(action.equals("notice_search")) {
			dispatcherUrl = "/jsp/Student/studentNotice.jsp";
			
		} else if(action.equals("notice_detail")) {

			dispatcherUrl = "/jsp/Student/studentNoticeDetail.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
		
	}
}
