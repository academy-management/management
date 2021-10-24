package mjh;

public class Sql {
	
	public static final String STUDENT_SELECT_ALL
		="Select s.sno, s.name,  s.year , d.name as d_name, s.tel, s.state from student s ,department d where s.dno= d.dno order by sno desc";
	
	public static final String STUDENT_INSERT
	="insert into student values(?,?,?,1,?,?,?,?,'재학',?)";
	
	public static final String STUDENT_UPDATE
	="update student set state = ? where sno=?";
	
}
