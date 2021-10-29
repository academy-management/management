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

	@Override
	public List<Professor> ProfessorAllInformation() {
		List<Professor> subjectList = new ArrayList<>(); 

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_LETURE);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Professor professor = new Professor();
				
				professor.setName(resultSet.getString("sname"));
				subject.setSemester(resultSet.getString("semester"));
				subject.setStart(resultSet.getString("startday"));
				subject.setEnd(resultSet.getString("endday"));
				subject.setP_name(resultSet.getString("pname"));
				subject.setState(resultSet.getString("state"));

				subjectList.add(subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return subjectList;
	}

	
	
}
