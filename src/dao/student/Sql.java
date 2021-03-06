package dao.student;



public class Sql {
	
	//STUDENT 테이블
	public static final String SUTUDENT_LOGIN_SQL = 
			"select * from student where sno= ? and password = ? ";
	
	public static final String SUTUDENT_MY_LOGIN_SQL = 
			"select * from student where and password = ? ";
	
	public static final String SM_DEP_CODE = 
			"select category, code, codeName from system_master where category = 'dep'";
	
	public static final String SUTUDENT_SNO = 
			"Select s.sno, d.name as d_name, s.name, s.password , s.tel, s.email, s.address ,s.dno from student s ,department d where s.dno=d.dno and sno = ?";
	
	public static final String STUDENT_SELECT_BY_ID = "select s.*, d.name as dname from student s, department d where sno = ?";
	
	public static final String STUDENT_SELECT_ALL = "select s.*, d.*, d.name as dname from student s, department d where s.dno = d.dno order by sno desc";
	
	public static final String STUDENT_SELECT_BY_PNO = "select distinct s.*, s.dno as s_dno, p.dno as p_dno, d.name as dname from student s, professor p, department d where s.dno = p.dno and s.dno = d.dno and p.dno = ?";
	
	public static final String STUDENT_SELECT_NAME = "select distinct s.*, s.dno as s_dno, p.dno as p_dno, d.name as dname from student s, professor p, department d where s.dno = p.dno and s.dno = d.dno and p.dno = ? and s.name like '%' || ? || '%' order by sno desc";
	
	public static final String STUDENT_SELECT_YEAR = "select distinct s.*, s.dno as s_dno, p.dno as p_dno, d.name as dname from student s, professor p, department d where s.dno = p.dno and s.dno = d.dno and p.dno = ? and s.year like '%' || ? order by sno desc";
	
	
	public static final String STUDENT_SELECT_BY_SUBNO = "select distinct re.regno, s.sno, s.name, d.name as dname, s.grade, re.score, re.subno from student s, REGISTER re, DEPARTMENT d, subject su where re.sno = s.sno and s.dno = d.dno and re.subno = ?";	
	
	public static final String STUDENT_SELECT_BY_SUBJECT_ALL = "select distinct re.regno, s.sno, s.name, d.name as dname, s.grade, re.score, re.subno, su.name as subname from student s, REGISTER re, DEPARTMENT d, subject su where re.sno = s.sno and s.dno = d.dno and re.subno = su.subno";
	
	
	public static final String UPDATE_TO_SCORE = "update REGISTER set score = ? where regno = ?";
	
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
	
	public static final String STUDENT_USER_UPDATE
	="UPDATE STUDENT SET NAME = ?, PASSWORD = ?, TEL = ?, EMAIL = ? , ADDRESS = ? WHERE SNO = ?";
	
	public static final String STUDENT_SCORE_ALL
	="select s.name as sname, s.score as score, s.startday as startday, s.endday as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.subno = s.subno and s.dno = p.dno";

	public static final String STUDENT_YEAR_SE
	="select s.name as sname, s.score as score, to_char(s.startday, 'YYYY.MM.DD') as startday, to_char(s.endday, 'YYYY.MM.DD') as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.subno = s.subno  and s.pno =p.pno  and r.year = ? and r.semester = ? and r.sno = ? ";

	public static final String STUDENT_YEAR_SE2
	="select s.name as sname, r.semester as semester, to_char(s.startday, 'YYYY.MM.DD') as startday, to_char(s.endday, 'YYYY.MM.DD') as endday, p.name as pname, r.score as rscore , r.regno from register r, subject s , professor p where r.subno = s.subno  and s.pno =p.pno  and r.year = ? and r.semester = ? and r.sno=?";
	
	public static final String STUDENT_LETURE
	="select s.name as sname, r.semester as semester, s.startday as startday, s.endday as endday, p.name as pname, s.state as state from register r, subject s , professor p where r.subno = s.subno  and s.pno =p.pno";


	

}
