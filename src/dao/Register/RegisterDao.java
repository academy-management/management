package dao.Register;

import model.Register;

public interface RegisterDao {
	
	void insert(Register register);
	int selectBySubno(String subno);
	int selectBySno(int sno, String subno);
	

}
