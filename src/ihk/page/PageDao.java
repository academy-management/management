package ihk.page;

public interface PageDao {
	
	/*공지사항 페이징 처리*/
	int getCountNotice();
	int getCountNoticeSearched(String searchSubject);
	int getCountNoticeDivided(String division);
	int getCountNoticeSearchedAndDivided(String searchSubject, String division);

}
