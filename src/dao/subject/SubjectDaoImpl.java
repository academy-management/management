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

	@Override
	public void insert(Subject subject) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUBJECT_INSERT);

			pStatement.setString(1, subject.getSubno());
			pStatement.setString(2, subject.getName());
			pStatement.setInt(3, subject.getGrade());
			pStatement.setString(4, subject.getScore());
			pStatement.setInt(5, subject.getPeople());
			pStatement.setString(6, subject.getRoom());
			pStatement.setString(7, subject.getDate());
			pStatement.setString(8, subject.getStart());
			pStatement.setString(9, subject.getEnd());
			pStatement.setString(10, subject.getDivision());
			pStatement.setInt(11, subject.getDno());
			pStatement.setString(12, subject.getPno());
		
		
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

		
	}

	@Override
	public Subject select_by_subno(String subno) {
		Subject subject = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUBJECT_SELECTBY_SUBNO);
			
			pStatement.setString(1, subno);
				
			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {

				subject = new Subject();
				subject.setSubno(resultSet.getString("subno"));
				subject.setName(resultSet.getString("name"));
				subject.setGrade(resultSet.getInt("grade"));
				subject.setScore(resultSet.getString("score"));
				subject.setPeople(resultSet.getInt("people"));
				subject.setRoom(resultSet.getString("room"));
				subject.setDate(resultSet.getString("subtime"));
				subject.setState(resultSet.getString("state"));
				subject.setStart(resultSet.getString("startday"));
				subject.setEnd(resultSet.getString("endday"));
				subject.setDivision(resultSet.getString("division"));
				subject.setDno(resultSet.getInt("dno"));
				subject.setPno(resultSet.getString("pno"));
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return subject;
	}

	@Override
	public void update(Subject subject) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUBJECT_UPDATE);

			pStatement.setString(1, subject.getName());
			pStatement.setInt(2, subject.getGrade());
			pStatement.setString(3, subject.getScore());
			pStatement.setString(4, subject.getRoom());
			pStatement.setInt(5, subject.getPeople());
			pStatement.setString(6, subject.getDate());
			pStatement.setString(7, subject.getStart());
			pStatement.setString(8, subject.getEnd());
			pStatement.setString(9, subject.getState());
			pStatement.setString(10, subject.getSubno());
		
		
		
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

		
		
	}

	@Override
	public List<Subject> selectByPno(String pno) {
		List<Subject> subjectList = new ArrayList<>();		

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUBJECT_SELECT_BY_PNO);
			pStatement.setString(1, pno);

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
}
	

