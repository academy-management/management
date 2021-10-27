package dao.manager;

public class Test {

	public static void main(String[] args) {
		ManagerDao dao = new ManagerDaoImpl();
		System.out.println(dao.selectById(1).toString());
		
		dao.managerUpdate(1, "변경이름", "패스워드변경", "010-0000-0001", "변경이메일@변경.com", "주소변경");
		System.out.println(dao.selectById(1).toString());
	}
}
