package mjh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		
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

	
	

}
