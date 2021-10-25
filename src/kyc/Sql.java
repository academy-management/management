package kyc;



public class Sql {
	
	//STUDENT 테이블
	public static final String STUDENT_SELECT_BY_ID = "select s.*, d.name as dname from student s, department d where sno = ?";
	
	public static final String STUDENT_SELECT_ALL = "select s.*, d.name as dname from student s, department d";
	
	public static final String STUDENT_SELECT_NAME = "select s.*, d.name as dname from student s, department d where s.name like '%' || ? || '%'";
	
	public static final String STUDENT_SELECT_YEAR = "select s.*, d.name as dname from student s, department d where s.year like '%' || ? || '%'";
	
	public static final String MEMO_SELECY_BY_ID = "select MEMOID, name, age from MEMO where MEMOID = ?";
	
	public static final String MEMO_UPDATE = "update MEMO set name = ?, age = ? where MEMOID = ?";
	
	public static final String MEMO_DELETE = "delete from MEMO where MEMOID = ?";
}
