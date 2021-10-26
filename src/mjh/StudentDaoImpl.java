package mjh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Student;

public class StudentDaoImpl implements StudentDao{

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

	
	

}
