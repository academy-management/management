package dao.Register;

public class Sql {
	
	public static final String PROFESSOR_INSERT =
			"insert into register(regno, year, semester, sno, subno) values(REG_SEQ.nextval, ?, ?, ?, ?)";

}
