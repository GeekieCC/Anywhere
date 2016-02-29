package cc.geekie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cc.geekie.dao.DataContract.UserDB;
import cc.geekie.domain.User;

public class UserDao {
	
	
	public void createTable() {        
		String createString = 
				"CREATE TABLE IF NOT EXISTS " + UserDB.TABLE_NAME + " (" +
						UserDB.COLUMN_NAME_ID + " varchar(32) NOT NULL, " +
						UserDB.COLUMN_NAME_USER_NAME + " varchar(32) NOT NULL, " +
						UserDB.COLUMN_NAME_PASSWORD + " varchar(32) NOT NULL, " +
						UserDB.COLUMN_NAME_EMAIL + " varchar(32) NOT NULL, " +
						"PRIMARY KEY ( "+UserDB.COLUMN_NAME_ID+" ) " +
						" )"
						;
    	Connection con = DataContract.getConnection();
    	if (con == null) return;
    	
		Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(createString);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} }
	        try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	
	public void insertUser(User user) {
		
		Connection con = DataContract.getConnection();
		if (con == null) return;
		Statement stmt = null;
		//user information
		String id = user.getId();
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();
		
		try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(
	            "insert into " + UserDB.TABLE_NAME +
	            " values("+ id + "," + 
	            		  username + "," +
	            		  password + "," +
	            		  email + ")");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} }
	        try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }

	}
	
	public User searchUserByName(String username) {
		User user = null;
		Connection con = DataContract.getConnection();
		Statement stmt = null;
		String query = 
				"select * from " +
						UserDB.TABLE_NAME + 
						" where " +
						UserDB.COLUMN_NAME_USER_NAME + 
						" = " + username;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				user = new User();
				user.setId(rs.getString(UserDB.COLUMN_NAME_ID));
				user.setUsername(username);
				user.setPassword(rs.getString(UserDB.COLUMN_NAME_PASSWORD));
				user.setEmail(rs.getString(UserDB.COLUMN_NAME_EMAIL));
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
