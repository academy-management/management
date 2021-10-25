package mjh;

public class Sql {
	
	public static final String STUDENT_SELECT_ALL
		="Select s.sno, s.name,  s.year , d.name as d_name, s.tel, s.state from student s ,department d where s.dno= d.dno order by sno desc";
	
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
