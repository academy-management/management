package dao.notice;

public class Sql {
	
	/*페이지별로 SELECT*/
	public static final String SELECT_NOTICE_TOTAL_SQL =
			"SELECT NNO, "
			+ "SUBJECT, "
			+ "TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, "
			+ "VIEWS FROM (SELECT ROWNUM RN, "
			+ "NOTICES.* FROM (SELECT * FROM NOTICE WHERE DIVISION = '전체' ORDER BY NNO DESC) NOTICES) "
			+ "WHERE RN BETWEEN ? AND ? ";
	
	public static final String SELECT_NOTICE_BY_DIVISION_SQL =
			"SELECT NNO, "
			+ "SUBJECT, "
			+ "TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, "
			+ "VIEWS FROM (SELECT ROWNUM RN, "
			+ "NOTICES.* FROM (SELECT * FROM NOTICE WHERE DIVISION = ? ORDER BY NNO DESC) NOTICES) "
			+ "WHERE RN BETWEEN ? AND ? ";

	public static final String SELECT_NOTICE_BY_SUBJECT_SQL =
			"SELECT NNO, "
			+ "SUBJECT, "
			+ "TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, "
			+ "VIEWS FROM (SELECT ROWNUM RN, NOTICES.* FROM "
			+ "(SELECT * FROM NOTICE WHERE SUBJECT LIKE '%'|| ? || '%' AND DIVISION = '전체' ORDER BY NNO DESC) NOTICES) WHERE RN BETWEEN ? AND ? ";
	
	public static final String SELECT_NOTICE_BY_DIVISION_AND_SUBJECT_SQL =
			"SELECT NNO, "
			+ "SUBJECT, "
			+ "TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, "
			+ "VIEWS FROM (SELECT ROWNUM RN, NOTICES.* FROM "
			+ "(SELECT * FROM NOTICE WHERE SUBJECT LIKE '%'|| ? || '%' AND DIVISION = ? ORDER BY NNO DESC) NOTICES) WHERE RN BETWEEN ? AND ? ";
	
	public static final String SELECT_NOTICE_BY_NNO_SQL =
			"SELECT NNO, SUBJECT, TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, CONTENTS, VIEWS FROM NOTICE WHERE NNO = ?";
	
	public static final String UPDATE_NOTICE_VIEWS_SQL =
			"UPDATE NOTICE SET VIEWS = ? WHERE NNO = ?";
	
	public static final String NOTICE_INSERT =
			"insert into Notice values(seq_notice.nextval, sysdate ,?,?,?,1,'admin')";
	
	public static final String NOTICE_DELETE =
			"delete from notice where nno = ?";
	
	
	
	
	
	/********************************************************************************************/
	public static final String SUTUDENT_LOGIN_SQL = 
			"select * from student where sno= ? and password = ? ";
	
	public static final String SUTUDENT_MY_LOGIN_SQL = 
			"select * from student where and password = ? ";
	
	public static final String SM_DEP_CODE = 
			"select category, code, codeName from system_master where category = 'dep'";
	
	public static final String SUTUDENT_SNO = 
			"select sno, password, name, grade ,year, address, tel, email, state, dno from student where sno =?";
	
	
	
	
	
	
	
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

	public static final String MANAGER_NOTICE_UPDATE = 
			"update notice set subject =? , contents=? , division =? where nno =?";
	
}
