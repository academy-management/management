package dao.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.JDBCUtil;
import model.Register;

public class RegisterDaoImpl implements RegisterDao{

	@Override
	public void insert(Register register) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PROFESSOR_INSERT);
			
			pStatement.setInt(1, register.getYear());
			pStatement.setInt(2, register.getSemester());
			pStatement.setInt(3, register.getSno());
			pStatement.setString(4, register.getSubno());
			
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

		
	}

}
