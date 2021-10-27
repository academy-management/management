package dao.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;
import model.Manager;
import model.Notice;

public class ManagerDaoImpl implements ManagerDao{

	@Override
	public Manager selectById(int id) {
		Manager manager = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_MANAGER_BY_ID);
			
			pStatement.setInt(1, id);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				manager = new Manager();
				
				manager.setId(resultSet.getInt("id"));
				manager.setName(resultSet.getString("name"));
				manager.setPassword(resultSet.getString("password"));
				manager.setTel(resultSet.getString("tel"));
				manager.setEmail(resultSet.getString("email"));
				manager.setAddress(resultSet.getString("address"));
				
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return manager;
	}

	@Override
	public void managerUpdate(int id, String name, String password, String tel, String email, String address) {		
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MANAGER_UPDATE);
			
			pStatement.setString(1, name);
			pStatement.setString(2, password);
			pStatement.setString(3, tel);
			pStatement.setString(4, email);
			pStatement.setString(5, address);
			pStatement.setInt(6, id);
			
			pStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

}
