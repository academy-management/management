package dao.kyc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import kyc.Sql;
import model.Student;
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
				subject.setSubno(resultSet.getInt("subno"));
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
	

