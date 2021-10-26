package kyc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Student;

public class StudentDaoImpl implements StudentDao {
		
	@Override
	public List<Student> selectAll() {

		List<Student> studentList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_SELECT_ALL);

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Student student = new Student();
				student.setSno(resultSet.getInt("sno"));
				student.setName(resultSet.getString("name"));
				student.setDname(resultSet.getString("dname"));
				student.setGrade(resultSet.getInt("grade"));
				student.setState(resultSet.getString("state"));
				
				studentList.add(student);				
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return studentList;
	}


	@Override
	public List<Student> selectName(String name) {
		List<Student> studentList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_SELECT_NAME);
			pStatement.setString(1, name);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Student student = new Student();
				student.setSno(resultSet.getInt("sno"));
				student.setName(resultSet.getString("name"));
				student.setDname(resultSet.getString("dname"));
				student.setGrade(resultSet.getInt("grade"));
				student.setState(resultSet.getString("state"));
				
				studentList.add(student);				
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return studentList;
	}


	@Override
	public List<Student> selectYear(int year) {
		List<Student> studentList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_SELECT_YEAR);
			pStatement.setInt(1, year);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Student student = new Student();
				student.setSno(resultSet.getInt("sno"));
				student.setName(resultSet.getString("name"));
				student.setDname(resultSet.getString("dname"));
				student.setGrade(resultSet.getInt("grade"));
				student.setState(resultSet.getString("state"));
				
				studentList.add(student);				
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return studentList;
	}


	@Override
	public Student selectByNo(String sno) {
		Student student = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_SELECT_BY_ID);
			pStatement.setString(1, sno);
			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				student = new Student();
				student.setSno(resultSet.getInt("sno"));
				student.setName(resultSet.getString("name"));
				student.setTel(resultSet.getString("tel"));
				student.setDname(resultSet.getString("dname"));
				student.setGrade(resultSet.getInt("grade"));
				student.setState(resultSet.getString("state"));
				student.setAddress(resultSet.getString("address"));
				student.setEmail(resultSet.getString("email"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return student;
	}


	@Override
	public List<Student> selectBySubjectNo(int subno) {
		List<Student> studentList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_SELECT_BY_SUBNO);
			pStatement.setInt(1, subno);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Student student = new Student();
				student.setSubno(resultSet.getInt("subno"));
				student.setRegno(resultSet.getInt("regno"));
				student.setSno(resultSet.getInt("sno"));
				student.setName(resultSet.getString("name"));
				student.setDname(resultSet.getString("dname"));
				student.setGrade(resultSet.getInt("grade"));
				student.setScore(resultSet.getString("score"));				
				studentList.add(student);				
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return studentList;
	}


	@Override
	public void updateToScore(int regno, String score) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.UPDATE_TO_SCORE);
			pStatement.setString(1, score);
			pStatement.setInt(2, regno);
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}		
	}

}
