package dao.Register;

public class Sql {
	
	public static final String STUDENT_INSERT_INTO_REGISTER =
			"insert into register(regno, year, semester, sno, subno) values(REG_SEQ.nextval, ?, ?, ?, ?)";
	
	public static final String SELECT_BY_SUBNO =
			"select count(*) as cnt from register where subno = ?";

}
