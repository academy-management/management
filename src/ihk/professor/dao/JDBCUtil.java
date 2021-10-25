package ihk.professor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String user = "scott";
	public static final String pw = "1234";
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pw);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	} 
	
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
		
		if(resultSet != null) {
			try {
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				resultSet = null;
			}
		}
		
		if(statement != null) {
			try {
				if(!statement.isClosed()) {
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				statement = null;
			}
		}
		
		if(connection != null) {
			try {
				if(!connection.isClosed()) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
}

