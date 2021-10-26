package jmj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import memo.model.Memo;

public class SutudentImpl implements SutudentDao {

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
	public int loginProcess(HttpServletRequest request, Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public Notice selectBymemoid(int Nno) {
		Notice notice = null; 

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_LIST);
			
			pStatement.setInt(1, Nno);
			
			resultSet = pStatement.executeQuery();
			
			if (resultSet.next()) {
				notice = new Notice();

				notice.setNno(resultSet.getInt("Nno"));
				notice.setTime(resultSet.getString("time"));
				notice.setDivision(resultSet.getString("division"));
				notice.setSubject(resultSet.getString("subject"));
				notice.setContents(resultSet.getString("contents"));
				notice.setViews(resultSet.getInt("views"));	
				notice.setId(resultSet.getInt("id"));	
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return notice;
	}

	@Override
	public Student mylogin(String pw) {
		Student student = null;

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUTUDENT_MY_LOGIN_SQL);

			pStatement.setString(1, pw);

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
	public Student selectBysno(int sno) {
		Student student = null; 

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUTUDENT_SNO);
			
			pStatement.setInt(1, sno);
			
			resultSet = pStatement.executeQuery();
			
			if (resultSet.next()) {
				student = new Student();

				student.setMemoid(resultSet.getInt("memoid"));
				Memo.setName(resultSet.getString("name"));
				Memo.setAge(resultSet.getInt("age"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return Memo;
	}
	
	
	
}
