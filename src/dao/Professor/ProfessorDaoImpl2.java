package dao.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Professor;


public class ProfessorDaoImpl2 implements ProfessorDao2{

	@Override
	public void update(Professor professor) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.UPDATE_PROFESSOR_INFO_SQL);
			
			pStatement.setString(1, professor.getPassword()); 
			pStatement.setString(2, professor.getName()); 
			pStatement.setString(3, professor.getAddress());
			pStatement.setString(4, professor.getTel());
			pStatement.setString(5, professor.getEmail());
			pStatement.setString(6, professor.getPno());
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}	
	}
	
}
