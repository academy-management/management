package ihk.page.copy;

public class PageManager {
	
	private int requestPage;
	
	public PageManager() {};

	public PageManager(int requestPage) {
		super();
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();

		pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PER_PAGE*(requestPage-1)+1);
		pageRowResult.setRowEndNumber(requestPage*PageInfo.ROW_COUNT_PER_PAGE);

		return pageRowResult;
	}
	
	public PageGroupResult getPageGroupResult(int cnt) {
		
		PageGroupResult pageGroupResult = new PageGroupResult();

		int reqPageGroupNumber  = (int) Math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT);

		pageGroupResult.setGroupStartNumber(((PageInfo.SHOW_PAGE_COUNT)*(reqPageGroupNumber -1))+1);
		pageGroupResult.setGroupEndNumber((PageInfo.SHOW_PAGE_COUNT)*reqPageGroupNumber);
		
		
		if(pageGroupResult.getGroupStartNumber()==1) {
			
			
			pageGroupResult.setBeforePage(false);
			
		}
		
		int totalPageNumber = (int) Math.ceil((double)cnt/PageInfo.ROW_COUNT_PER_PAGE);
		
		if(pageGroupResult.getGroupEndNumber() > totalPageNumber) {
			
			pageGroupResult.setGroupEndNumber(totalPageNumber);
			
		}
		
		if(pageGroupResult.getGroupEndNumber() == totalPageNumber) {
			
			pageGroupResult.setAfterPage(false);
		}
		
		pageGroupResult.setSelectPageNumber(requestPage);

		
		return pageGroupResult;
	
	}
}
