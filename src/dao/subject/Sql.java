package dao.subject;

public class Sql {
	public static final String SUBJECT_SELECT_ALL = "select * from SUBJECT"; 
	
	public static final String SUBJECT_SELECT_BY_PNO = "select s.pno, s.subno , s.name , p.name as p_name, s.startday, s.endday, s.score , s.subtime , s.state from subject s,professor p where s.pno= p.pno and s.pno = ? order by s.pno desc";
	
	public static final String SUBJECT_SELECTNS = "select s.subno , s.name , p.name as p_name , s.score , s.subtime , s.state from subject s,professor p where s.pno= p.pno and s.name like ? and p.name like ? order by s.pno desc"; 
	
	public static final String SUBJECT_INSERT = "insert into SUBJECT values(?,?,?,?,?,?,?,'강의',?,?,?,?,?)";
	
	public static final String SUBJECT_SELECTBY_SUBNO =
			"select * from subject where subno =?";
	
	public static final String SUBJECT_UPDATE=
			"update subject set name = ? , grade = ? , score = ? , room = ? , people =?, subtime = ? , state= ? where subno = ? ";
}
