package ihk.professor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;
import model.Professor;


public class ProfessorDaoImpl implements ProfessorDao{

	@Override
	public Professor selectByPno(int pno) {
		
		Professor professor = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_BY_PROFESSOR_PNO_SQL);
			
			pStatement.setInt(1, pno);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				professor = new Professor();
				
				professor.setPno(resultSet.getString("pno"));
				professor.setPassword(resultSet.getString("password"));
				professor.setName(resultSet.getString("name"));
				professor.setAddress(resultSet.getString("address"));
				professor.setTel(resultSet.getString("tel"));
				professor.setEmail(resultSet.getString("email"));
				professor.setD_name(resultSet.getString("dname"));
				
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return professor;	
	}

	@Override
	public void update(int pno) {
		// TODO Auto-generated method stub
		
	}


}