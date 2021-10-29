package dao.Professor;

public class Sql2 {
	public static final String PROFESSOR_INFORMATION
	="select d.name as dname, p.name as pname, p.Major as Major, p.state as state, p.address as address, p.pro_room as room , p.tel as tel, p.email as email from professor p, department d where p.dno = ?";
	public static final String PROFESSOR_INFORMATION_ALL
	="select d.name as dname, p.name as pname, p.Major as Major, p.state as state, p.address as address, p.pro_room as room , p.tel as tel, p.email as email from professor p, department d where p.dno = d.dno";
}
