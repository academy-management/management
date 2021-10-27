package dao.manager;

public class Sql {
	public static final String SELECT_MANAGER_BY_ID 
	= "select * from manager where id = ?";
	
	public static final String MANAGER_UPDATE 
	= "update manager set name = ?, password = ?, tel = ?, email = ?, address = ? where id = ?";
}
