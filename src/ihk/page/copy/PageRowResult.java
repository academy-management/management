package ihk.page.copy;

public class PageRowResult {
	
	private int rowStartNumber; // 화면에 보여줄 시작 줄 번호
	private int rowEndNumber; // 화면에 보여줄 끝 줄번호
	
	public int getRowStartNumber() {
		return rowStartNumber;
	}
	public void setRowStartNumber(int rowStartNumber) {
		this.rowStartNumber = rowStartNumber;
	}
	public int getRowEndNumber() {
		return rowEndNumber;
	}
	public void setRowEndNumber(int rowEndNumber) {
		this.rowEndNumber = rowEndNumber;
	}

}

