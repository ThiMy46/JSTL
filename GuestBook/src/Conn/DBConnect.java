package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
	
	static Statement statement = null;
	
	public static Connection getConnection() {
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/GuestBook","root","12345");
		}
		catch (Exception ex){
			System.out.println("Error connection " + ex);
		}
		return conn;
	}

	// hàm trả danh sách lưu trong ResultSet thông qua câu truy vấn str
	public static ResultSet ExecuteQueryResultSet(Connection conn, String str) {
		ResultSet rs = null;
		try {
			statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = statement.executeQuery(str);
		} catch (SQLException ex) {
			Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
		} 
		/*finally {
			// finally block used to close resources
			try {
				if (statement != null || rs != null) {
					conn.close();
				}
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}*/
		return rs;
	}
	// Hàm thực hiện lệnh trả về true hoặc false
	public static boolean MyExcuteUpdateNonQuery(Connection conn, CallableStatement stmt) {
		boolean f = false;
		try {
			stmt.executeUpdate();
			f = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null || stmt != null) {
					conn.close();
				}
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return f;
	}

}
