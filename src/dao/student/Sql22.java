package dao.student;

public class Sql22 {
	
	public static final String SUTUDENT_BY_SUBNO = 
			"select s.sno, s.name, d.name as dname, s.grade, s.tel, s.email from student s join department d "
			+ "on s.dno = d.dno "
			+ "join register r "
			+ "on s.sno = r.sno "
			+ "join subject sub "
			+ "on r.subno = sub.subno "
			+ "where sub.subno = ?";
	
}
