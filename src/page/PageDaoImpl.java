package page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;

public class PageDaoImpl implements PageDao{

	@Override
	public int getCountNotice() {
		
		int cnt = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(PageSql.CNT_NOTICE_ALL_SQL);
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				cnt = Integer.parseInt(resultSet.getString("cnt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return cnt;
	}

	@Override
	public int getCountNoticeSearched(String searchSubject) {
		int cnt = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(PageSql.CNT_NOTICE_BY_SUBJECT_SQL);
			
			pStatement.setString(1, searchSubject);
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				cnt = Integer.parseInt(resultSet.getString("cnt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return cnt;
	}

	@Override
	public int getCountNoticeDivided(String division) {
		int cnt = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(PageSql.CNT_NOTICE_BY_DIVISION_SQL);
			
			pStatement.setString(1, division);
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				cnt = Integer.parseInt(resultSet.getString("cnt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return cnt;
	}

	@Override
	public int getCountNoticeSearchedAndDivided(String searchSubject, String division) {
		int cnt = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(PageSql.CNT_NOTICE_BY_SUBJECT_AND_DIVISION_SQL);
			
			pStatement.setString(1, searchSubject);
			pStatement.setString(2, division);
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				cnt = Integer.parseInt(resultSet.getString("cnt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return cnt;
	}

}