package cc.geekie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataContract {
	
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String USERNAME = "wangce";
	public static final String PASSWORD = "wangce";
	
	public class UserDB {
		public static final String TABLE_NAME = "USER_TABLE";
		public static final String COLUMN_NAME_USER_NAME = "USER_NAME";
		public static final String COLUMN_NAME_PASSWORD = "PASSWORD";
		public static final String COLUMN_NAME_EMAIL = "EMAIL";
		public static final String COLUMN_NAME_ID = "ID";
	}
	
	public class GpsDB {
		public static final String TABLE_NAME = "GPS_TABLE";
		public static final String COLUMN_NAME_ID = "ID";
		public static final String COLUMN_NAME_LONGITUDE = "LONGITUDE";
		public static final String COLUMN_NAME_LATITUDE = "LATITUDE";
		public static final String COLUMN_NAME_TIME = "TIME";
	}
	
	public static Connection getConnection() {

		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}
}
