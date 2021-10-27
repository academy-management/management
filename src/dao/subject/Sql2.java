package dao.subject;

public class Sql2 {
	public static final String SUBJECT_SELECT_BY_PNO = 
			"select subno, name, to_char(startday, 'YYYY.MM.DD') as sd, to_char(endday, 'YYYY.MM.DD') as ed, subtime, room "
			+ "from subject "
			+ "where pno = ?";
	
	
	public static final String SUBJECT_SELECT_BY_REGISTER_YEAR_AND_SEMESTER = 
			"select s.subno, s.name, to_char(s.startday, 'YYYY.MM.DD') sd, to_char(s.endday, 'YYYY.MM.DD') ed, s.subtime, s.room, r.year, r.semester "
			+ "from subject s inner join register r on s.subno = r.subno "
			+ "where s.pno = ? and r.year = ? and r.semester = ?";
	
	public static final String SUBJECT_SELECT_BY_SUBNO =
			"select subno, name, to_char(startday, 'YYYY.MM.DD') sd, to_char(endday, 'YYYY.MM.DD') ed "
			+ "from subject where subno =?";
}
