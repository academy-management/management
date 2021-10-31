package dao.Register;

public class Sql {
	
	public static final String STUDENT_INSERT_INTO_REGISTER =
			"insert into register(regno, year, semester, sno, subno) values(REG_SEQ.nextval, ?, ?, ?, ?)";
	
	public static final String SELECT_BY_SUBNO =
			"select count(*) as cnt from register where subno = ?";
	
	public static final String SELECT_BY_SNO =
			"select count(*) as cnt from register where subno = ? and sno = ?";
	
	public static final String REGISTER_DELETE =
			"delete from register where regno = ? ";
}
