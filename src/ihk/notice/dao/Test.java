package ihk.notice.dao;

import java.util.List;

import ihk.notice.model.Notice;

public class Test {
	
	public static void main(String[] args) {
		
		NoticeDao dao = new NoticeDaoImpl();
		
		List<Notice> arr1 = dao.selectAll(1);
		
		for (Notice notice : arr1) {
			System.out.println(notice.toString());
		}
		
		List<Notice> arr2 = dao.selectByDivision(1, "컴퓨터공학과");
		
		for (Notice notice : arr2) {
			System.out.println(notice.toString());
		}
		
		List<Notice> arr3 =dao.selectByDivisionAndSubject(1, "컴퓨터공학과", "시간표");
		
		for (Notice notice : arr3) {
			System.out.println(notice.toString());
		}
		
	}

}
