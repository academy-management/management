package ihk.notice.dao;

public class Sql {
	
	/*페이지별로 SELECT*/
	public static final String SELECT_NOTICE_TOTAL_SQL =
			"SELECT NNO, SUBJECT, TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, VIEWS FROM (SELECT ROWNUM RN, NOTICES.* FROM (SELECT * FROM NOTICE ORDER BY NNO DESC) NOTICES) WHERE RN BETWEEN ? AND ?";
	
	public static final String SELECT_NOTICE_BY_DIVISION_SQL =
			"SELECT NNO, SUBJECT, TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, VIEWS FROM (SELECT ROWNUM RN, NOTICES.* FROM (SELECT * FROM NOTICE WHERE DIVISION = ? ORDER BY NNO DESC) NOTICES) WHERE RN BETWEEN ? AND ? ";

	public static final String SELECT_NOTICE_BY_SUBJECT_SQL =
			"SELECT NNO, SUBJECT, TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, VIEWS FROM (SELECT ROWNUM RN, NOTICES.* FROM (SELECT * FROM NOTICE WHERE SUBJECT LIKE '%'|| ? || '%' ORDER BY NNO DESC) NOTICES) WHERE RN BETWEEN ? AND ? ";
	
	public static final String SELECT_NOTICE_BY_DIVISION_AND_SUBJECT_SQL =
			"SELECT NNO, SUBJECT, TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, VIEWS FROM (SELECT ROWNUM RN, NOTICES.* FROM (SELECT * FROM NOTICE WHERE SUBJECT LIKE '%'|| ? || '%' AND DIVISION = ? ORDER BY NNO DESC) NOTICES) WHERE RN BETWEEN ? AND ? ";
	
	public static final String SELECT_NOTICE_BY_NNO_SQL =
			"SELECT NNO, SUBJECT, TO_CHAR(TIME, 'YYYY.MM.DD') AS TIME, CONTENTS, VIEWS FROM NOTICE WHERE NNO = ?";
	
	public static final String UPDATE_NOTICE_VIEWS_SQL =
			"UPDATE NOTICE SET VIEWS = ? WHERE NNO = ?";
	
}
