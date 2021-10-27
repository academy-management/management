package dao.manager;

import model.Manager;

public interface ManagerDao {
	public Manager selectById(int id);
	public void managerUpdate(int id, String name, String password, String tel, String email, String address);
}
