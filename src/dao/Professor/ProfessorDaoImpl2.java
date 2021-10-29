package dao.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Professor;
import model.Subject;


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

	@Override
	public List<Professor> Professordep(int professor_ch) {
		List<Professor> professorList = new ArrayList<>();   

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.PROFESSOR_INFORMATION);
			
			pStatement.setInt(1, professor_ch);
			
			resultSet = pStatement.executeQuery();
			
			if (resultSet.next()) {
				Professor professor = new Professor();
				professor.setName(resultSet.getString("pname"));
				professor.setMajor(resultSet.getString("major"));
				professor.setState(resultSet.getString("state"));
				professor.setAddress(resultSet.getString("address"));
				professor.setPro_room(resultSet.getString("room"));
				professor.setTel(resultSet.getString("tel"));
				professor.setEmail(resultSet.getString("email"));
				
				professorList.add(professor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return professorList;
	}

	@Override
	public List<Professor> ProfessorAllInformation() {
		List<Professor> professorList = new ArrayList<>();   

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.PROFESSOR_INFORMATION_ALL);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Professor professor = new Professor();
				
				professor.setName(resultSet.getString("pname"));
				professor.setMajor(resultSet.getString("major"));
				professor.setState(resultSet.getString("state"));
				professor.setAddress(resultSet.getString("address"));
				professor.setPro_room(resultSet.getString("room"));
				professor.setTel(resultSet.getString("tel"));
				professor.setEmail(resultSet.getString("email"));

				professorList.add(professor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return professorList;
	}

	

	
	
}
