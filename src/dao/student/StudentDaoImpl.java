package dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Student;
import model.SystemMaster;

public class StudentDaoImpl implements StudentDao {
	
	@Override
	public void insert(Student student) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_INSERT);

			pStatement.setInt(1, student.getSno());
			pStatement.setString(2, student.getPassword());
			pStatement.setString(3, student.getName());
			pStatement.setInt(4, student.getYear());
			pStatement.setString(5, student.getAddress());
			pStatement.setString(6, student.getTel());
			pStatement.setString(7, student.getEmail());
			pStatement.setString(8, student.getD_name());
		
		
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

		
	}
	
	
	@Override
	public void update(int sno, String state) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_UPDATE);

			pStatement.setString(1, state);
			pStatement.setInt(2, sno);
			
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

		
	}

	@Override
	public List<Student> selectByNYN(String name, String year, String department) {
		List<Student> studentList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.STUDENT_SELECT_NYN);
			pStatement.setString(1,"%"+name+"%");
			pStatement.setString(2,"%"+year+"%");
			pStatement.setString(3,"%"+department+"%");
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Student student = new Student();

				student.setSno(resultSet.getInt("sno"));
				student.setName(resultSet.getString("name"));
				student.setYear(resultSet.getInt("year"));
				student.setD_name(resultSet.getString("d_name"));
				student.setTel(resultSet.getString("tel"));
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
	
	@Override
	public Student login(int sno, String pw) {
		Student student = null;

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUTUDENT_LOGIN_SQL);

			pStatement.setInt(1, sno);
			pStatement.setString(2, pw);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				student = new Student();

				student.setSno(resultSet.getInt("sno"));
				student.setPassword(resultSet.getString("password"));
				student.setName(resultSet.getString("name"));
				student.setGrade(resultSet.getInt("grade"));
				student.setYear(resultSet.getInt("year"));
				student.setAddress(resultSet.getString("address"));
				student.setTel(resultSet.getString("tel"));
				student.setEmail(resultSet.getString("email"));
				student.setState(resultSet.getString("state"));
				student.setDno(resultSet.getInt("dno"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return student;
	}

	@Override
	public List<SystemMaster> selectDepCode() {
		List<SystemMaster> depList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SM_DEP_CODE);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				SystemMaster sm = new SystemMaster();

				sm.setCategory(resultSet.getString("category"));
				sm.setCode(resultSet.getString("code"));
				sm.setCodeName(resultSet.getString("codeName"));

				depList.add(sm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return depList;
	}	

	
	@Override
	public void selectBysno(Student student) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUTUDENT_MY_UPDATE);

			pStatement.setInt(1, student.getSno());
			pStatement.setInt(2, student.getDno());
			pStatement.setString(3, student.getName());
			pStatement.setString(4, student.getPassword());
			pStatement.setString(5, student.getTel());
			pStatement.setString(6, student.getEmail());
			pStatement.setString(7, student.getAddress());
			

			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}

}
