package dao.subject;

import model.Subject;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubjectDao subDao = new SubjectDaoImpl();
		for (Subject subject : subDao.selectAll()) {
			System.out.println(subject.toString());
		}
	}

}
