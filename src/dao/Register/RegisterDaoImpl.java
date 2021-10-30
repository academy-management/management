package dao.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;
import model.Register;
import model.Student;

public class RegisterDaoImpl implements RegisterDao{

	@Override
	public void insert(Register register) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_INSERT_INTO_REGISTER);
			
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

	@Override
	public int selectBySubno(String subno) {
		
		int cnt = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_BY_SUBNO);
			
			pStatement.setString(1, subno);
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				
				cnt = resultSet.getInt("cnt");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return cnt;
	}

	@Override
	public int selectBySno(int sno, String subno) {
		int cnt = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_BY_SNO);
			
			pStatement.setString(1, subno);
			pStatement.setInt(2, sno);
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				
				cnt = resultSet.getInt("cnt");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return cnt;
	}

}
