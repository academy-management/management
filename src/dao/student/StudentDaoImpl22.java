package dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Student;

public class StudentDaoImpl22 implements StudentDao22{

	@Override
	public List<Student> selectBySubno(int subno) {
		
		List<Student> studentList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql22.SUTUDENT_BY_SUBNO);
			
			pStatement.setInt(1, subno);
	
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Student student = new Student();
				
				student.setSno(resultSet.getInt("sno"));
				student.setName(resultSet.getString("name"));
				student.setYear(resultSet.getInt("year"));
				student.setD_name(resultSet.getString("dname"));
				student.setGrade(resultSet.getInt("grade"));
				student.setTel(resultSet.getString("tel"));
				student.setEmail(resultSet.getString("email"));

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
