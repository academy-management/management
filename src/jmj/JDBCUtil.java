package jmj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

	// 디비연결 접속관련
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// 로그인 관련  //오라클 디비를 어느 계정 에서 만들었는 지를 확인 해야함!!!
	private static final String user = "scott";
	private static final String password = "tiger";

	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			//db연결
			Class.forName(driver);
			connection = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
		// connection getconnteion 리턴
	}
	//pStatement의 부모 Statement
		public static void close(ResultSet resultSet, Statement statment, Connection connection) {
			if(resultSet != null) {
				try {
					if(!resultSet.isClosed()) {//resultset이 닫혀 있는지 물어보는 조건
						resultSet.close(); //닫혀 있지않으면 닫아라
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					resultSet = null; //닫고서 값을 널을 넣어줌
				}
			}
			if(statment != null) {
				try {
					if(!statment.isClosed()) {//resultset이 닫혀 있는지 물어보는 조건
						statment.close(); //닫혀 있지않으면 닫아라
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					statment = null; //닫고서 값을 널을 넣어줌
				}
			}
			if(connection != null) {
				try {
					if(!connection.isClosed()) {//resultset이 닫혀 있는지 물어보는 조건
						connection.close(); //닫혀 있지않으면 닫아라
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					connection = null; //닫고서 값을 널을 넣어줌
				}
			}
		}
	
}
