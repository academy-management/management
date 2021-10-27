package dao.student;



public class Sql {
	
	//STUDENT 테이블
	public static final String SUTUDENT_LOGIN_SQL = 
			"select * from student where sno= ? and password = ? ";
	
	public static final String SUTUDENT_MY_LOGIN_SQL = 
			"select * from student where and password = ? ";
	
	public static final String SM_DEP_CODE = 
			"select category, code, codeName from system_master where category = 'dep'";
	
	public static final String SUTUDENT_MY_UPDATE = 
			"select sno,dno, name, password, tel, email, address from student";
	
	public static final String STUDENT_SELECT_BY_ID = "select s.*, d.name as dname from student s, department d where sno = ?";
	
	public static final String STUDENT_SELECT_ALL = "select s.*, d.* as dname from student s, department d order by sno desc";
	
	public static final String STUDENT_SELECT_NAME = "select s.*, d.name as dname from student s, department d where s.name like '%' || ? || '%'";
	
	public static final String STUDENT_SELECT_YEAR = "select s.*, d.name as dname from student s, department d where s.year like '%' || ? || '%'";
	
	public static final String STUDENT_SELECT_BY_SUBNO = "select distinct re.regno, s.sno, s.name, d.name as dname, s.grade, re.score from student s, REGISTER re, DEPARTMENT d, subject su where re.sno = s.sno and s.dno = d.dno and re.subno = ?";	
	
	public static final String UPDATE_TO_SCORE = "update REGISTER set score = 'B' where regno = ?";
	
	public static final String MEMO_DELETE = "delete from MEMO where MEMOID = ?";
	
	public static final String STUDENT_SELECT_NYN
	="Select s.sno, s.name,  s.year , d.name as d_name, s.tel, s.state from student s ,department d where s.dno= d.dno and s.name like ? and s.year like ? and d.name like ? order by sno desc";
	
	public static final String STUDENT_INSERT
	="insert into student values(?,?,?,1,?,?,?,?,'재학',?)";
	
	public static final String STUDENT_UPDATE
	="update student set state = ? where sno=?";
	
	public static final String PROFESSOR_SELECT_ALL
	="Select p.pno, p.name, d.name as d_name , p.major, p.tel ,p.state from professor p , department d where p.dno= d.dno order by pno desc";
	
	public static final String PROFESSOR_SELECT_ND
	="Select p.pno, p.name, d.name as d_name , p.major, p.tel ,p.state from professor p , department d where p.dno= d.dno and p.name like ? and d.name like ? order by pno desc";
	
	public static final String PROFESSOR_INSERT
	="insert into professor values(?,?,?,?,null,'재직',?,?,?,?,?)";
	
	public static final String PROFESSOR_UPDATE
	="update professor set state = ? where pno=?";
	
	
	
	
}
