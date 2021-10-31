package page;

public class PageSql {
	
	/* CNT 개수 구하는 SQL문*/
	public static final String CNT_NOTICE_ALL_SQL =
			"SELECT COUNT(*) AS CNT FROM NOTICE WHERE DIVISION = '전체'";
	
	public static final String CNT_NOTICE_BY_SUBJECT_SQL =
			"SELECT COUNT(*) AS CNT FROM NOTICE WHERE SUBJECT LIKE '%'|| ? || '%' AND DIVISION = '전체'";
	
	public static final String CNT_NOTICE_BY_DIVISION_SQL =
			"SELECT COUNT(*) AS CNT FROM NOTICE WHERE DIVISION = ?";
	
	public static final String CNT_NOTICE_BY_SUBJECT_AND_DIVISION_SQL =
			"SELECT COUNT(*) AS CNT FROM NOTICE WHERE SUBJECT LIKE '%'|| ? || '%' AND DIVISION = ?";

}