package jmj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

	// ��񿬰� ���Ӱ���
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// �α��� ����  //����Ŭ ��� ��� ���� ���� ������� ���� Ȯ�� �ؾ���!!!
	private static final String user = "scott";
	private static final String password = "tiger";

	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			//db����
			Class.forName(driver);
			connection = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
		// connection getconnteion ����
	}
	//pStatement�� �θ� Statement
		public static void close(ResultSet resultSet, Statement statment, Connection connection) {
			if(resultSet != null) {
				try {
					if(!resultSet.isClosed()) {//resultset�� ���� �ִ��� ����� ����
						resultSet.close(); //���� ���������� �ݾƶ�
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					resultSet = null; //�ݰ� ���� ���� �־���
				}
			}
			if(statment != null) {
				try {
					if(!statment.isClosed()) {//resultset�� ���� �ִ��� ����� ����
						statment.close(); //���� ���������� �ݾƶ�
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					statment = null; //�ݰ� ���� ���� �־���
				}
			}
			if(connection != null) {
				try {
					if(!connection.isClosed()) {//resultset�� ���� �ִ��� ����� ����
						connection.close(); //���� ���������� �ݾƶ�
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					connection = null; //�ݰ� ���� ���� �־���
				}
			}
		}
	
}
