package dao.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Subject;

public class SubjectDaoImpl2 implements SubjectDao2 {

	@Override
	public List<Subject> selectByPno(String pno) {
		List<Subject> subjectList = new ArrayList<>();		

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.SUBJECT_SELECT_BY_PNO);
			
			pStatement.setString(1, pno);
				
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Subject subject = new Subject();
				subject.setSubno(resultSet.getString("subno"));
				subject.setName(resultSet.getString("name"));
				subject.setStart(resultSet.getString("sd"));
				subject.setEnd(resultSet.getString("ed"));
				subject.setDate(resultSet.getString("subtime"));
				subject.setRoom(resultSet.getString("room"));
				
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
	public List<Subject> selectByRegisterYearAndSemester(String pno, int year, int semester) {
		List<Subject> subjectList = new ArrayList<>();		

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.SUBJECT_SELECT_BY_REGISTER_YEAR_AND_SEMESTER);
			
			pStatement.setString(1, pno);
			pStatement.setInt(2, year);
			pStatement.setInt(3, semester);
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Subject subject = new Subject();
				subject.setSubno(resultSet.getString("subno"));
				subject.setName(resultSet.getString("name"));
				subject.setStart(resultSet.getString("sd"));
				subject.setEnd(resultSet.getString("ed"));
				subject.setDate(resultSet.getString("subtime"));
				subject.setRoom(resultSet.getString("room"));
				
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
	public Subject selectBySubno(int subno) {
		Subject subject = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.SUBJECT_SELECT_BY_SUBNO);
			
			pStatement.setInt(1, subno);
				
			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {

				subject = new Subject();
				subject.setSubno(resultSet.getString("subno"));
				subject.setName(resultSet.getString("name"));
				subject.setStart(resultSet.getString("sd"));
				subject.setEnd(resultSet.getString("ed"));
		
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return subject;
	}
}
