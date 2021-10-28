package dao.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import model.Notice;
import page.PageManager;
import page.PageRowResult;


public class NoticeDaoImpl implements NoticeDao {
	
	public List<Notice> selectAll(int requestPage) {
		List<Notice> noticeList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_NOTICE_TOTAL_SQL);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			
			pStatement.setInt(1, prr.getRowStartNumber());
			pStatement.setInt(2, prr.getRowEndNumber());
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Notice notice = new Notice();		
				
				notice.setNno(resultSet.getInt("nno"));
				notice.setSubject(resultSet.getString("subject"));
				notice.setTime(resultSet.getString("time"));
				notice.setViews(resultSet.getInt("views"));
				
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return noticeList;
	}

	public List<Notice> selectByDivision(int requestPage, String division) {
		List<Notice> noticeList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_NOTICE_BY_DIVISION_SQL);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			
			pStatement.setString(1, division);
			pStatement.setInt(2, prr.getRowStartNumber());
			pStatement.setInt(3, prr.getRowEndNumber());
		
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Notice notice = new Notice();		
				
				notice.setNno(resultSet.getInt("nno"));
				notice.setSubject(resultSet.getString("subject"));
				notice.setTime(resultSet.getString("time"));
				notice.setViews(resultSet.getInt("views"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return noticeList;
	}


	@Override
	public List<Notice> selectBySubject(int requestPage, String subject) {
		List<Notice> noticeList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_NOTICE_BY_SUBJECT_SQL);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			
			pStatement.setString(1, subject);
			pStatement.setInt(2, prr.getRowStartNumber());
			pStatement.setInt(3, prr.getRowEndNumber());
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Notice notice = new Notice();		
				
				notice.setNno(resultSet.getInt("nno"));
				notice.setSubject(resultSet.getString("subject"));
				notice.setTime(resultSet.getString("time"));
				notice.setViews(resultSet.getInt("views"));
				
				noticeList.add(notice);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return noticeList;
	}


	@Override
	public List<Notice> selectByDivisionAndSubject(int requestPage, String division, String subject) {
		List<Notice> noticeList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_NOTICE_BY_DIVISION_AND_SUBJECT_SQL);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			
			pStatement.setString(1, subject);
			pStatement.setString(2, division);
			pStatement.setInt(3, prr.getRowStartNumber());
			pStatement.setInt(4, prr.getRowEndNumber());
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Notice notice = new Notice();		
				
				notice.setNno(resultSet.getInt("nno"));
				notice.setSubject(resultSet.getString("subject"));
				notice.setTime(resultSet.getString("time"));
				notice.setViews(resultSet.getInt("views"));
				
				noticeList.add(notice);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return noticeList;
	}

	@Override
	public Notice selectByNno(int nno) {
		Notice notice = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_NOTICE_BY_NNO_SQL);
			
			pStatement.setInt(1, nno);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				notice = new Notice();
				
				notice.setTime(resultSet.getString("time"));
				notice.setViews(resultSet.getInt("views"));
				notice.setSubject(resultSet.getString("subject"));
				notice.setContents(resultSet.getString("contents"));
				notice.setViews(resultSet.getInt("views"));
				
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return notice;
	}

	@Override
	public void updateToViews(int views, int nno) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.UPDATE_NOTICE_VIEWS_SQL);
			
			pStatement.setInt(1, views);
			pStatement.setInt(2, nno);
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void insert(Notice notice) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_INSERT);

			pStatement.setString(1, notice.getDivision_d());
			pStatement.setString(2, notice.getSubject());
			pStatement.setString(3, notice.getContents());
			
		
		
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void delete(int nno) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_DELETE);

			pStatement.setInt(1, nno);
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

}