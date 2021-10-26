package kyc;



public class Sql {
	
	//STUDENT 테이블
	public static final String STUDENT_SELECT_BY_ID = "select s.*, d.name as dname from student s, department d where sno = ?";
	
	public static final String STUDENT_SELECT_ALL = "select s.*, d.name as dname from student s, department d";
	
	public static final String STUDENT_SELECT_NAME = "select s.*, d.name as dname from student s, department d where s.name like '%' || ? || '%'";
	
	public static final String STUDENT_SELECT_YEAR = "select s.*, d.name as dname from student s, department d where s.year like '%' || ? || '%'";
	
	public static final String STUDENT_SELECT_BY_SUBNO = "select distinct re.regno, s.sno, s.name, d.name as dname, s.grade, re.score from student s, REGISTER re, DEPARTMENT d, subject su where re.sno = s.sno and s.dno = d.dno and re.subno = ?";
	
	public static final String UPDATE_TO_SCORE = "update REGISTER set score = 'B' where regno = ?";
	
	public static final String MEMO_DELETE = "delete from MEMO where MEMOID = ?";
}
