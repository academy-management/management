package dao.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Professor;

public class ProfessorDaoImpl implements ProfessorDao{

	@Override
	public List<Professor> selectAll() {
		
		List<Professor> professorList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PROFESSOR_SELECT_ALL);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Professor professor = new Professor();

				professor.setPno(resultSet.getString("pno"));
				professor.setName(resultSet.getString("name"));
				professor.setD_name(resultSet.getString("d_name"));
				professor.setMajor(resultSet.getString("major"));
				professor.setTel(resultSet.getString("tel"));
				professor.setState(resultSet.getString("state"));

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
	public void insert(model.Professor professor) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PROFESSOR_INSERT);
			
			pStatement.setString(1, professor.getPno());
			pStatement.setString(2, professor.getPassword());
			pStatement.setString(3, professor.getMajor());
			pStatement.setString(4, professor.getName());
			pStatement.setString(5, professor.getAddress());
			pStatement.setString(6, professor.getPro_room());
			pStatement.setString(7, professor.getTel());
			pStatement.setString(8, professor.getEmail());
			pStatement.setString(9, professor.getD_name());
		
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

		
	}

	@Override
	public void update(String pno, String state) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PROFESSOR_UPDATE);

			pStatement.setString(1, state);
			pStatement.setString(2, pno);
			
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

		
	}

	@Override
	public List<Professor> selectByND(String name, String department) {
		List<Professor> professorList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PROFESSOR_SELECT_ND);
			pStatement.setString(1,"%"+name+"%");
			pStatement.setString(2,"%"+department+"%");
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Professor professor = new Professor();

				professor.setPno(resultSet.getString("pno"));
				professor.setName(resultSet.getString("name"));
				professor.setD_name(resultSet.getString("d_name"));
				professor.setMajor(resultSet.getString("major"));
				professor.setTel(resultSet.getString("tel"));
				professor.setState(resultSet.getString("state"));

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
	public Professor selectByPno(String pno) {
		
		Professor professor = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_BY_PROFESSOR_PNO_SQL);
			
			pStatement.setString(1, pno);
			
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
				professor.setDno(resultSet.getInt("dno"));
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
