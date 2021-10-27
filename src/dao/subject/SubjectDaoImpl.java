package dao.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Subject;

public class SubjectDaoImpl implements SubjectDao{

	@Override
	public List<Subject> selectAll() {
		List<Subject> subjectList = new ArrayList<>();		

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUBJECT_SELECT_ALL);

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Subject subject = new Subject();
				
				subject.setSubno(resultSet.getString("subno"));
				subject.setName(resultSet.getString("name"));
				subject.setStart(resultSet.getString("startday"));
				subject.setEnd(resultSet.getString("endday"));				
				subjectList.add(subject);			
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return subjectList;
	}

	@Override
	public List<Subject> selectByNS(String name, String subject) {
		
		List<Subject> subjectList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUBJECT_SELECTNS);
			pStatement.setString(1,"%"+name+"%");
			pStatement.setString(2,"%"+subject+"%");
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Subject subject2 = new Subject();
				
				subject2.setSubno(resultSet.getString("subno"));
				subject2.setName(resultSet.getString("name"));
				subject2.setP_name(resultSet.getString("p_name"));
				subject2.setScore(resultSet.getString("score"));	
				subject2.setDate(resultSet.getString("subtime"));
				subject2.setState(resultSet.getString("state"));	
				
				subjectList.add(subject2);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return subjectList;
	}
}
	

