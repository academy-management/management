package dao.subject;

public class Sql {
	public static final String SUBJECT_SELECT_ALL = "select * from SUBJECT"; 
	
	public static final String SUBJECT_SELECTNS = "select s.subno , s.name , p.name as p_name , s.score , s.subtime , s.state from subject s,professor p where s.pno= p.pno and s.name like ? and p.name like ? order by s.pno desc"; 
	
	public static final String SUBJECT_INSERT = "insert into SUBJECT values(?,?,?,?,?,?,?,'강의',?,?,?,?,?)";
}
