package dao.manager;

import model.Manager;

public interface ManagerDao {
	public Manager selectById(String id);
	public void managerUpdate(String id, String name, String password, String tel, String email, String address);
}
