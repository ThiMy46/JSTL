package DAO;
import Conn.*;
import Model.*;
import Conn.DBConnect;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;

public class GuestBookDAO {
	CallableStatement stmt = null;

	public GuestBookDAO() {
		//
	}
	
	
	public Boolean AddComment(String Name, String Message) throws SQLException {
		Connection conn = DBConnect.getConnection();
		try {
			String call = "{call spInsertGuestBook(?,?)}";
			CallableStatement stmt = conn.prepareCall(call);
			stmt.setString(1, Name);
			stmt.setString(2, Message);

			return DBConnect.MyExcuteUpdateNonQuery(conn, stmt);
		} catch (Exception e) {
			return false;
		}finally {
			conn.close();
		}
	}
	
	public Boolean UpdateGuestBook(int Key, String Name, String Message) throws SQLException {
		Connection conn = DBConnect.getConnection();
		try {
			String call = "{call spUpdateGuestBook(?,?,?)}";
			CallableStatement stmt = conn.prepareCall(call);
			stmt.setInt(1, Key);
			stmt.setString(2, Name);
			stmt.setString(3, Message);

			return DBConnect.MyExcuteUpdateNonQuery(conn, stmt);
		} catch (Exception e) {
			return false;
		}finally {
			conn.close();
		}
	}
	
	public Boolean DeleteGuestBook(int Key) throws SQLException {
		Connection conn = DBConnect.getConnection();
		try {
			String call = "{call spDeleteGuestBook(?)}";
			CallableStatement stmt = conn.prepareCall(call);
			stmt.setInt(1, Key);

			return DBConnect.MyExcuteUpdateNonQuery(conn, stmt);
		} catch (Exception e) {
			return false;
		}finally {
			conn.close();
		}
	}
}
