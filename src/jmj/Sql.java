package jmj;

public class Sql {
	
	public static final String SUTUDENT_LOGIN_SQL = 
			"select * from student where sno= ? and password = ? ";
	
	public static final String SUTUDENT_MY_LOGIN_SQL = 
			"select * from student where and password = ? ";
	
	public static final String SM_DEP_CODE = 
			"select category, code, codeName from system_master where category = 'dep'";
	
	public static final String SUTUDENT_SNO = 
			"";
	
	
	
	
	
	
	
	public static final String BOOK_SELECT_PAGE_SQL = 
			"select memoid, name, age"
			+ " from (select rownum rn, memos.* from (select * from memo order by memoid desc) memos)"
			+ " where rn between ? and ?";
	
	public static final String NOTICE_LIST=
	"select Nno, subject, time, views from Notice where Nno=?";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final String CUSTOMER_SELECTID_SQL = 
			"select count(*) as cnt from cutomerjoin where id=?";
	
	

	
	public static final String BOARD_SELECT_SQL = 
			"select nom, subject, content, wdata, cnt, id from BBS";
	public static final String BOARD_SELECTSUBJECT_SQL = 
			"select nom, subject, content, wdata, cnt, id from BBS where nom = ?";

}
