package dao.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

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
	public Subject selectBySubno(String subno) {
		Subject subject = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.SUBJECT_SELECT_BY_SUBNO);
			
			pStatement.setString(1, subno);
				
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
	
	

	public List<Subject> selectAll(int dno) {
		List<Subject> subjectList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.SUBJECT_SELECT_ALL);
			
			pStatement.setInt(1,  dno);

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Subject subject = new Subject();
				
				subject.setName(resultSet.getString("name"));
				subject.setGrade(resultSet.getInt("grade"));
				subject.setStart(resultSet.getString("sd"));
				subject.setEnd(resultSet.getString("ed"));
				subject.setScore(resultSet.getString("score"));
				subject.setDate(resultSet.getString("subtime"));
				subject.setState(resultSet.getString("state"));
				subject.setP_name(resultSet.getString("pname"));
				subject.setRoom(resultSet.getString("room"));
				subject.setPeople(resultSet.getInt("people"));
				
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
	public List<Subject> selectByDivision(String division, int dno) {
		List<Subject> subjectList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.SUBJECT_SELECT_BY_DIVISION_ALL);
			
			pStatement.setString(1, division);
			pStatement.setInt(2, dno);

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Subject subject = new Subject();
				
				subject.setName(resultSet.getString("name"));
				subject.setGrade(resultSet.getInt("grade"));
				subject.setStart(resultSet.getString("sd"));
				subject.setEnd(resultSet.getString("ed"));
				subject.setScore(resultSet.getString("score"));
				subject.setDate(resultSet.getString("subtime"));
				subject.setState(resultSet.getString("state"));
				subject.setP_name(resultSet.getString("pname"));
				subject.setRoom(resultSet.getString("room"));
				subject.setPeople(resultSet.getInt("people"));
				
				subjectList.add(subject);			
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return subjectList;
	}
	
	public List<Subject> selectByDivisionAndGrade(String division, int dno, String grade) {
		List<Subject> subjectList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql2.SUBJECT_SELECT_BY_DIVISION_AND_GRADE);
			
			pStatement.setString(1, division);		
			pStatement.setInt(2, dno);
			pStatement.setString(3, grade);	

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Subject subject = new Subject();
				
				subject.setName(resultSet.getString("name"));
				subject.setGrade(resultSet.getInt("grade"));
				subject.setStart(resultSet.getString("sd"));
				subject.setEnd(resultSet.getString("ed"));
				subject.setScore(resultSet.getString("score"));
				subject.setDate(resultSet.getString("subtime"));
				subject.setState(resultSet.getString("state"));
				subject.setP_name(resultSet.getString("pname"));
				subject.setRoom(resultSet.getString("room"));
				subject.setPeople(resultSet.getInt("people"));
				
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
