package dao.Professor;

public class Sql {
	
	public static final String SELECT_BY_PROFESSOR_PNO_SQL =
			"SELECT P.PNO AS PNO, P.PASSWORD AS PASSWORD, P.TEL AS TEL, P.NAME AS NAME, P.ADDRESS AS ADDRESS, P.EMAIL AS EMAIL, D.NAME AS DNAME FROM PROFESSOR P INNER JOIN DEPARTMENT D ON P.DNO = D.DNO WHERE P.PNO = ?";
	
	public static final String UPDATE_PROFESSOR_INFO_SQL =
			"UPDATE PROFESSOR SET PASSWORD = ?, NAME = ?, ADDRESS = ?, TEL = ?, EMAIL = ? WHERE PNO = ? ";
	
	public static final String PROFESSOR_SELECT_ALL
	="Select p.pno, p.name, d.name as d_name , p.major, p.tel ,p.state from professor p , department d where p.dno= d.dno order by pno desc";
	
	public static final String PROFESSOR_SELECT_ND
	="Select p.pno, p.name, d.name as d_name , p.major, p.tel ,p.state from professor p , department d where p.dno= d.dno and p.name like ? and d.name like ? order by pno desc";
	
	public static final String PROFESSOR_INSERT
	="insert into professor values(?,?,?,?,null,'재직',?,?,?,?,?)";
	
	public static final String PROFESSOR_UPDATE
	="update professor set state = ? where pno=?";
	
}
